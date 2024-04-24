package scul.projectscul.domain.review.presentation.dto.response

import scul.projectscul.domain.review.domain.Review
import java.time.LocalDate
import java.util.UUID

data class GetReviewsResponse(
        val reviewList: List<ReviewsResponse>
) {
    data class ReviewsResponse (
            val id: UUID?,
            val writer: String,
            val content: String,
            val createdAt: LocalDate
    ) {
        constructor(review: Review): this(
                id = review.id,
                writer = review.user.name,
                content = review.content,
                createdAt = review.createdAt
        )
    }
}

