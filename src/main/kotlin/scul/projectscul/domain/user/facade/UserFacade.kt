package scul.projectscul.domain.user.facade

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
        val email = SecurityContextHolder.getContext().authentication.name
        print(email)
        return userRepository.findByEmail(email) ?: throw UserNotFoundException
    }
}
