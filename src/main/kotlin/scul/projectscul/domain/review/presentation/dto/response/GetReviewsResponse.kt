package scul.projectscul.domain.review.presentation.dto.response

import scul.projectscul.domain.review.domain.Review
import java.util.UUID

data class GetReviewsResponse(

        val reviewList: List<ReviewsResponse>
) {
    data class ReviewsResponse (
            val id: UUID?,
            val title: String,
            val content: String
    ) {
        constructor(review: Review): this(
                id = review.id,
                title = review.title,
                content = review.content
        )
    }
}

