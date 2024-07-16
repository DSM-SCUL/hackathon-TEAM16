package scul.projectscul.domain.user.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import scul.projectscul.domain.user.domain.User
import scul.projectscul.domain.user.facade.UserFacade
import scul.projectscul.domain.user.presentation.response.MyPageResponse

@Service
@Transactional(readOnly = true)
class MyPageService (
        private val userFacade: UserFacade
) {

    fun execute(): MyPageResponse {
        val currentUser: User = userFacade.getCurrentUser()

        return MyPageResponse.of(currentUser)
    }
}