package scul.projectscul.domain.user.service

import jakarta.transaction.Transactional
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import scul.projectscul.domain.user.domain.repository.UserRepository
import scul.projectscul.domain.user.exception.PasswordMisMatchException
import scul.projectscul.domain.user.presentation.request.LoginRequest
import scul.projectscul.global.redis.dto.TokenResponse
import scul.projectscul.global.security.jwt.JwtTokenProvider

@Service
@Transactional
class LoginService (
        private val jwtProvider: JwtTokenProvider,
        private val passwordEncoder: PasswordEncoder,
        private val userRepository: UserRepository
){
    fun execute(request: LoginRequest): TokenResponse {
        val user = userRepository.findByAccountId(request.accountId)

            if(!passwordEncoder.matches(request.password, user.password)) {
                throw PasswordMisMatchException
            }
                return jwtProvider.generateTokens(accountId = request.accountId)
    }
}
