package scul.projectscul.domain.review.presentation

import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import scul.projectscul.domain.review.presentation.dto.request.CreateReviewRequest
import scul.projectscul.domain.review.presentation.dto.response.GetReviewsResponse
import scul.projectscul.domain.review.service.CreateReviewService
import scul.projectscul.domain.review.service.GetMyReviewService
import scul.projectscul.domain.review.service.GetReviewsService
import java.util.UUID

@RequestMapping("/reviews")
@RestController
class ReviewController (
        private val createReviewService: CreateReviewService,
        private val getReviewsService: GetReviewsService,
        private val getMyReviewService: GetMyReviewService
) {

    @PostMapping("/{culture-id}")
    fun createReview(
            @RequestBody request: CreateReviewRequest,
            @PathVariable("culture-id") @NotNull cultureId: UUID
    ) {
        createReviewService.execute(request, cultureId)
    }

    @GetMapping("/{culture-id}")
    fun getReviews(@PathVariable("culture-id") @NotNull cultureId: UUID) : GetReviewsResponse {
        return getReviewsService.execute(cultureId)
    }

    @GetMapping
    fun getReviews() : GetReviewsResponse {
        return getMyReviewService.execute()
    }
}
