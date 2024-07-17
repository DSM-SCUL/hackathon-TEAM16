package scul.projectscul.domain.user.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import scul.projectscul.domain.user.domain.repository.UserRepository
import scul.projectscul.domain.user.exception.UserNotFoundException
import scul.projectscul.domain.user.presentation.request.LoginRequest
import scul.projectscul.global.redis.dto.TokenResponse
import scul.projectscul.global.security.jwt.JwtTokenProvider

@Service
@Transactional
class LoginService (
        private val jwtProvider: JwtTokenProvider,
        private val userRepository: UserRepository
){
    fun execute(request: LoginRequest): TokenResponse {

        if(!userRepository.existsByEmail((request.email))) {
            throw UserNotFoundException

        }
                return jwtProvider.generateToken(userId  = request.email)
    }
}
