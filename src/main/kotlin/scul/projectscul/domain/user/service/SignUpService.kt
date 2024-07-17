package scul.projectscul.domain.user.service

import scul.projectscul.domain.user.domain.User
import scul.projectscul.domain.user.domain.repository.UserRepository
import scul.projectscul.domain.user.exception.UserAlreadyExistsException
import scul.projectscul.domain.user.presentation.request.SignUpRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import scul.projectscul.domain.user.domain.Enum.Tier
import scul.projectscul.global.redis.dto.TokenResponse
import scul.projectscul.global.security.jwt.JwtTokenProvider

@Service
@Transactional
class SignUpService(
        private val userRepository: UserRepository,
        private val jwtTokenProvider: JwtTokenProvider,
) {

    fun execute(request: SignUpRequest): TokenResponse {
        if (userRepository.existsByEmail(request.email)) {
            throw UserAlreadyExistsException
        }

        userRepository.save(
                User(
                        id = null,
                        name = request.name,
                        email = request.email,
                        birth = request.birth,
                        profileImage = request.profileImage,
                        tier = Tier.UNRANKED
                )
        )
        return jwtTokenProvider.generateToken(userId = request.email)
    }
}
