package scul.projectscul.domain.user.facade

import lombok.RequiredArgsConstructor
import scul.projectscul.domain.user.domain.User
import scul.projectscul.domain.user.domain.repository.UserRepository
import scul.projectscul.domain.user.exception.UserNotFoundException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import java.util.UUID

@Component
@RequiredArgsConstructor
class UserFacade(
        private val userRepository: UserRepository
) {

    fun getCurrentUser(): User {
        val authentication = SecurityContextHolder.getContext().authentication

        val email = authentication.name

        println(authentication)
        println("dddddddd------------")
        println(authentication.name)
        println("dddddddd------------")

        return userRepository.findByEmail(email) ?: throw UserNotFoundException
    }
}
