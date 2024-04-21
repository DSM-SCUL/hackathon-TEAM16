package scul.projectscul.domain.user.service

import jakarta.transaction.Transactional
import scul.projectscul.domain.user.domain.User
import scul.projectscul.domain.user.domain.repository.UserRepository
import scul.projectscul.domain.user.exception.UserAlreadyExistsException
import scul.projectscul.domain.user.presentation.request.SignUpRequest
import org.springframework.stereotype.Service

@Service
class SignUpService (
        private val userRepository: UserRepository,
){

    @Transactional
    fun execute(request: SignUpRequest) {
        if (userRepository.existsByAccountId(request.accountId)){
            throw UserAlreadyExistsException
        }

        userRepository.save(
                User(
                        id = null,
                        name = request.name,
                        accountId = request.accountId,
                        password = request.password
                )
        )
    }
}
