package scul.projectscul.domain.review.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import scul.projectscul.domain.review.domain.Review

interface ReviewRepository : JpaRepository<Review, Long> {
}