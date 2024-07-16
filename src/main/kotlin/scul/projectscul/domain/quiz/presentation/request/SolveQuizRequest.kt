package scul.projectscul.domain.quiz.presentation.request

import jakarta.validation.constraints.NotBlank

data class SolveQuizRequest(
        @field:NotBlank
        val answer: String
)
