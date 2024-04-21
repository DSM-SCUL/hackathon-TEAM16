package scul.projectscul.domain.review.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import scul.projectscul.domain.review.domain.Review
import scul.projectscul.domain.user.domain.User
import java.util.UUID

interface ReviewRepository : JpaRepository<Review, UUID> {

    fun findReviewsByCulture_Id(id: UUID) : List<Review>

    fun findReviewsByUser(user: User) : List<Review>

}