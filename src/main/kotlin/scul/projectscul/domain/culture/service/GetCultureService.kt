package scul.projectscul.domain.culture.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import scul.projectscul.domain.bookmark.domain.repository.BookMarkRepository
import scul.projectscul.domain.culture.domain.Culture
import scul.projectscul.domain.culture.domain.repository.CultureRepository
import scul.projectscul.domain.culture.presentation.dto.response.GetCultureResponse
import scul.projectscul.domain.user.domain.User
import scul.projectscul.domain.user.facade.UserFacade
import java.util.UUID

@Service
@Transactional(readOnly = true)
class GetCultureService (
        private val bookMarkRepository: BookMarkRepository,
        private val cultureRepository: CultureRepository,
        private val userFacade: UserFacade
) {
    fun execute(cultureId: UUID): GetCultureResponse {

        val currentUser: User = userFacade.getCurrentUser()
        val culture: Culture = cultureRepository.findCultureById(cultureId)
        val isBookMarked = bookMarkRepository.existBookMarkByCultureAndUser(culture ,currentUser)

        return GetCultureResponse.of(culture, isBookMarked)
    }
}