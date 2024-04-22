package scul.projectscul.domain.bookmark.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import scul.projectscul.domain.bookmark.domain.repository.BookMarkRepository
import scul.projectscul.domain.culture.domain.repository.CultureRepository
import scul.projectscul.domain.culture.presentation.dto.response.GetCultureListResponse
import scul.projectscul.domain.user.facade.UserFacade
/*
@Service
@Transactional
class GetMyBookMarkService (
        private val userFacade: UserFacade,
        private val bookMarkRepository: BookMarkRepository,
        private val cultureRepository: CultureRepository
) {

    fun execute() : GetCultureListResponse{
        val currentUser = userFacade.getCurrentUser()

        val bookMarkList = bookMarkRepository.findBookMarksByUser(currentUser)

        //return GetCultureListResponse(
        //        cultureRepository.findCulturesByUserOrCultureLink()
        //)

    }
}

 */