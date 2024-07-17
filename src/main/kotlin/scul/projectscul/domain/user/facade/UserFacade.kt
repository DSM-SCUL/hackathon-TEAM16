package scul.projectscul.domain.user.facade

import com.example.kotlinpractice.global.security.auth.AuthDetails
import scul.projectscul.domain.user.domain.User
import scul.projectscul.domain.user.domain.repository.UserRepository
import scul.projectscul.domain.user.exception.UserNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class UserFacade(
        private val userRepository: UserRepository
) {

    fun getCurrentUser(): User {
        val principal = SecurityContextHolder.getContext().authentication.principal

        // principal이 String 타입이라고 가정하고 UUID로 변환
        val id = UUID.fromString(principal as String)

        return userRepository.findByIdOrNull(id) ?: throw UserNotFoundException
    }
}