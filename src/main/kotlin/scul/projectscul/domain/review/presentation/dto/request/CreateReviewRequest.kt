package scul.projectscul.domain.review.presentation.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreateReviewRequest(

        @field:NotBlank
        @field:Size(max = 50)
        val title: String,

        @field:NotBlank
        val content: String
)
