package scul.projectscul.domain.bookmark.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import scul.projectscul.domain.bookmark.domain.BookMark
import scul.projectscul.domain.bookmark.domain.repository.BookMarkRepository
import scul.projectscul.domain.culture.domain.repository.CultureRepository
import scul.projectscul.domain.user.facade.UserFacade
import java.util.UUID


@Service
@Transactional
class BookMarkService (
        private val cultureRepository: CultureRepository,
        private val bookMarkRepository: BookMarkRepository,
        private val userFacade: UserFacade
) {

    fun execute(cultureId: UUID) {
        val currentUser = userFacade.getCurrentUser()
        val culture = cultureRepository.findCultureById(cultureId)

        val bookMark = bookMarkRepository.findBookMarkByCultureAndUser(culture, currentUser)
        if (bookMark != null) {
            bookMarkRepository.delete(bookMark)
        } else {
            bookMarkRepository.save(
                    BookMark(
                         user = currentUser,
                         culture = culture
                    )
            )
        }
    }
}