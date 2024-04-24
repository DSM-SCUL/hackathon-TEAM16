package scul.projectscul.domain.bookmark.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import scul.projectscul.domain.bookmark.domain.repository.BookMarkRepository
import scul.projectscul.domain.culture.presentation.dto.response.GetCultureListResponse
import scul.projectscul.domain.user.facade.UserFacade

@Service
@Transactional(readOnly = true)
class GetMyBookMarkService (
        private val userFacade: UserFacade,
        private val bookMarkRepository: BookMarkRepository,
) {

    fun execute(): GetCultureListResponse {
        val currentUser = userFacade.getCurrentUser()

        val bookMarkList = bookMarkRepository.findBookMarksByUser(currentUser)

        val cultureList = bookMarkList.mapNotNull { it.culture }

        return GetCultureListResponse(
                cultureList.map { cultureItem ->
                    GetCultureListResponse.CultureListResponse(
                            id = cultureItem.id,
                            location = cultureItem.location,
                            placeName = cultureItem.placeName,
                            ticketPrice = cultureItem.ticketPrice,
                            isBookMarked = true,
                            imageUrl = cultureItem.imageUrl,
                            cultureName = cultureItem.cultureName,
                            wantedPeople = cultureItem.wantedPeople
                    )
                }
        )
    }
}