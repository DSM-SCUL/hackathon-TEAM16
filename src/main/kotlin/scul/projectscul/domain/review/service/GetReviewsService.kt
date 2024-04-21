package scul.projectscul.domain.review.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import scul.projectscul.domain.review.domain.Review
import scul.projectscul.domain.review.domain.repository.ReviewRepository
import scul.projectscul.domain.review.presentation.dto.response.GetReviewsResponse
import java.util.UUID

@Service
@Transactional(readOnly = true)
class GetReviewsService (
        private val reviewRepository: ReviewRepository
){
    fun execute(cultureId: UUID): GetReviewsResponse {

        val reviews: List<Review> = reviewRepository.findReviewsByCulture_Id(cultureId)


        return GetReviewsResponse(
                reviews.map {
                            GetReviewsResponse.ReviewsResponse(it)
                }
        )
    }
}
