package scul.projectscul.domain.user.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import scul.projectscul.domain.user.facade.UserFacade
import scul.projectscul.domain.user.presentation.request.ProfileUpdateRequest

@Service
@Transactional
class ProfileUpdateService (
        private val userFacade: UserFacade,
) {

    fun execute(request: ProfileUpdateRequest) {
        val currentUser = userFacade.getCurrentUser()

        currentUser.updateImage(request.profileImage)
    }
}
