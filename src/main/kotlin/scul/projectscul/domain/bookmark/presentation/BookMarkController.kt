package scul.projectscul.domain.bookmark.presentation

import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.*
import scul.projectscul.domain.bookmark.service.BookMarkService
import scul.projectscul.domain.bookmark.service.GetMyBookMarkService
import scul.projectscul.domain.culture.presentation.dto.response.GetCultureListResponse
import java.util.*

@RestController
@RequestMapping("/scul/bookmarks")
class BookMarkController (
        private val bookMarkService: BookMarkService,
        private val getMyBookMarkService: GetMyBookMarkService
) {

    @PostMapping("/{culture-id}")
    fun createReview(
            @PathVariable("culture-id") @NotNull cultureId: UUID
    ) {
        bookMarkService.execute(cultureId)
    }

    @GetMapping
    fun getMyBookMarks(): GetCultureListResponse {
        return getMyBookMarkService.execute()
    }

}
