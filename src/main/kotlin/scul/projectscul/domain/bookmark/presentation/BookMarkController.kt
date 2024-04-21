package scul.projectscul.domain.bookmark.presentation

import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.*
import scul.projectscul.domain.bookmark.service.BookMarkService
import scul.projectscul.domain.review.presentation.dto.request.CreateReviewRequest
import scul.projectscul.domain.review.presentation.dto.response.GetReviewsResponse
import java.util.*

@RestController
@RequestMapping("/bookmarks")
class BookMarkController (
        private val bookMarkService: BookMarkService
) {

    @PostMapping("/{culture-id}")
    fun createReview(
            @PathVariable("culture-id") @NotNull cultureId: UUID
    ) {
        bookMarkService.execute(cultureId)
    }

    @GetMapping
    fun getMyBookMarks() : GetCultureListResponse {
        return getMyReviewService.execute()
    }
}