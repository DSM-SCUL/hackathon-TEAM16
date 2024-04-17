package scul.projectscul.global.security.jwt

import scul.projectscul.global.redis.repository.RefreshTokenRepository
import scul.projectscul.global.security.auth.AuthDetailsService
import com.example.kotlinpractice.global.security.exception.ExpiredTokenException
import com.study.kotlkotlin.global.security.exception.InvalidTokenException
import io.jsonwebtoken.*
import io.jsonwebtoken.security.Keys
import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import scul.projectscul.global.redis.domain.RefreshToken
import scul.projectscul.global.redis.dto.TokenResponse
import java.time.LocalDateTime
import java.util.*


@Component
class JwtTokenProvider(
        private val jwtProperties: JwtProperties,
        private val refreshTokenRepository: RefreshTokenRepository,
        private val authDetailsService: AuthDetailsService
) {

    fun generateTokens(accountId: String): TokenResponse {
        return TokenResponse(
            accessToken = createAccessToken(accountId),
            accessTokenExp = LocalDateTime.now().plusSeconds(jwtProperties.accessExp),
            refreshToken = createRefreshToken(accountId)
        )
    }

    fun createAccessToken(accountId: String): String {
        return createToken(accountId, "access", jwtProperties.accessExp)
    }

    fun createRefreshToken(accountId: String): String {
        val token = createToken(accountId, "refresh", jwtProperties.refreshExp)
        refreshTokenRepository.save(
            RefreshToken(
                username = accountId,
                token = token,
                expiration = jwtProperties.refreshExp * 1000
            )
        )
        return token
    }

    private fun createToken(username: String, jwtType: String, exp: Long): String {
        return Jwts.builder()
            .signWith(Keys.hmacShaKeyFor(jwtProperties.secretKey.toByteArray()), SignatureAlgorithm.HS256)
            .setSubject(username)
            .setHeaderParam(Header.JWT_TYPE, jwtType)
            .setId(username)
            .setExpiration(Date(System.currentTimeMillis() + exp * 1000))
            .setIssuedAt(Date())
            .compact()
    }

    fun getAuthentication(token: String): Authentication {

        val claims = getClaims(token)
        if (claims.header[Header.JWT_TYPE] == "access") {
            throw InvalidTokenException.EXCEPTION
        }

        val details = authDetailsService.loadUserByUsername(claims.body.id)
        return UsernamePasswordAuthenticationToken(details, "", details.authorities)
    }

    private fun getClaims(token: String): Jws<Claims> {
        return try {
            Jwts
                .parser()
                .setSigningKey(jwtProperties.secretKey)
                .parseClaimsJws(token)
        } catch (e: Exception) {
            when (e) {
                is ExpiredTokenException -> throw ExpiredTokenException.EXCEPTION
                else -> throw InvalidTokenException.EXCEPTION
            }
        }
    }

    fun resolveToken(request: HttpServletRequest): String? {

        val bearerToken = request.getHeader(jwtProperties.header)

        if (bearerToken != null && (bearerToken.startsWith(jwtProperties.header))) {
            return bearerToken.substring(7)
        }
        return null
    }

}