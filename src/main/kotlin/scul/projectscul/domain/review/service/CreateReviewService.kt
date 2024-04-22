package scul.projectscul.domain.review.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import scul.projectscul.domain.culture.domain.repository.CultureRepository
import scul.projectscul.domain.review.domain.Review
import scul.projectscul.domain.review.domain.repository.ReviewRepository
import scul.projectscul.domain.review.presentation.dto.request.CreateReviewRequest
import scul.projectscul.domain.user.facade.UserFacade
import java.time.LocalDate
import java.util.UUID

@Service
@Transactional
class CreateReviewService (
        private val reviewRepository: ReviewRepository,
        private val cultureRepository: CultureRepository,
        private val userFacade: UserFacade
){
    fun execute(request: CreateReviewRequest, cultureId: UUID) {
        val currentUser = userFacade.getCurrentUser()
        val culture = cultureRepository.findCultureById(cultureId)

        val now = LocalDate.now()

        reviewRepository.save(
                Review(
                        id = null,
                        content = request.content,
                        user = currentUser,
                        culture = culture,
                        createdAt = now
                )
        )
    }
}
