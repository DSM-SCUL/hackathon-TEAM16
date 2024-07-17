package scul.projectscul.global.security.jwt

import scul.projectscul.global.security.auth.AuthDetailsService
import io.jsonwebtoken.*

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import scul.projectscul.global.redis.dto.TokenResponse
import java.util.*
import javax.servlet.http.HttpServletRequest


@Component
class JwtTokenProvider(
        private val jwtProperties: JwtProperties,
        private val authDetailsService: AuthDetailsService,
) {
    companion object {
        private const val ACCESS_KEY = "access_token"
        private const val REFRESH_KEY = "refresh_token"
    }

    fun generateToken(userId: String): TokenResponse {
        val accessToken = generateAccessToken(userId, ACCESS_KEY, jwtProperties.accessExp)
        //val refreshToken = generateRefreshToken( REFRESH_KEY, jwtProperties.refreshExp)
        //refreshTokenRepository.save(
          //      RefreshToken(userId, refreshToken, jwtProperties.refreshExp)
        //)
        return TokenResponse(accessToken, jwtProperties.accessExp)
    }


    fun getRole(token: String) = getJws(token).body["role"].toString()



    private fun generateAccessToken(id: String,  type: String, exp: Long): String =
            Jwts.builder()
                    .setSubject(id)
                    .setHeaderParam("typ", type)
                    .claim("role", id)
                    .signWith(SignatureAlgorithm.HS256, jwtProperties.secretKey)
                    .setExpiration(Date(System.currentTimeMillis() + exp * 1000))
                    .setIssuedAt(Date())
                    .compact()

    private fun generateRefreshToken(type: String, exp: Long): String =
            Jwts.builder()
                    .setHeaderParam("typ", type)
                    .claim("role", type)
                    .signWith(SignatureAlgorithm.HS256, jwtProperties.secretKey)
                    .setExpiration(Date(System.currentTimeMillis() + exp * 1000))
                    .setIssuedAt(Date())
                    .compact()

    fun resolveToken(request: HttpServletRequest): String? =
            request.getHeader(jwtProperties.header)?.also {
                if (it.startsWith(jwtProperties.prefix)) {
                    return it.substring(jwtProperties.prefix.length)
                }
            }

    fun authentication(token: String): Authentication? {
        val body: Claims = getJws(token).body
        val userDetails: UserDetails = getDetails(body)
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    private fun getJws(token: String): Jws<Claims> {
        return Jwts.parser().setSigningKey(jwtProperties.secretKey).parseClaimsJws(token)
    }

    private fun getDetails(body: Claims): UserDetails {
            return authDetailsService.loadUserByUsername(body.subject)
        }

}
