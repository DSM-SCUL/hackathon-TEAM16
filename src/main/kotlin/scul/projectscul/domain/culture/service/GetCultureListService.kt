package scul.projectscul.domain.culture.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import scul.projectscul.domain.bookmark.domain.BookMark
import scul.projectscul.domain.bookmark.domain.repository.BookMarkRepository
import scul.projectscul.domain.culture.domain.Culture
import scul.projectscul.domain.culture.domain.repository.CultureRepository
import scul.projectscul.domain.culture.presentation.dto.response.GetCultureListResponse
import scul.projectscul.domain.user.facade.UserFacade
import java.util.UUID


@Service
@Transactional(readOnly = true)
class GetCultureListService (
        private val cultureRepository: CultureRepository
) {
    fun execute(title: String, wantPeople: String): GetCultureListResponse {
        val culture: List<Culture> = cultureRepository.findCulturesByWantedPeopleContainingAndCultureNameContaining(wantPeople, title)

        return GetCultureListResponse(
                culture.map {
                    GetCultureListResponse.CultureListResponse(it)
                }
        )
    }
}