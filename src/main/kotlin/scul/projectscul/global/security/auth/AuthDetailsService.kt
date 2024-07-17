package scul.projectscul.global.security.auth

import com.example.kotlinpractice.global.security.auth.AuthDetails
import scul.projectscul.domain.user.domain.User
import scul.projectscul.domain.user.domain.repository.UserRepository
import scul.projectscul.domain.user.exception.UserNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthDetailsService(
    private val userRepository: UserRepository
): UserDetailsService {

    override fun loadUserByUsername(email: String): UserDetails {
        print("asdf")
        val user: User = userRepository.findByEmail(email) ?: throw UserNotFoundException
        return AuthDetails(user)
    }
}
