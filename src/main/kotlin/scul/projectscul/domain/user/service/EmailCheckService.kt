package scul.projectscul.domain.user.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import scul.projectscul.domain.user.domain.repository.UserRepository
import scul.projectscul.domain.user.presentation.request.EmailCheckRequest

@Service
@Transactional(readOnly = true)
class EmailCheckService (
        private val userRepository: UserRepository
) {
    fun execute(request: EmailCheckRequest) : Boolean{

        return !userRepository.existsByEmail(request.email)

    }
}
