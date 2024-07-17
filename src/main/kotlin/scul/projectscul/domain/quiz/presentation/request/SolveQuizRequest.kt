package scul.projectscul.domain.quiz.presentation.request

import javax.validation.constraints.NotBlank


data class SolveQuizRequest(
        @field:NotBlank
        val answer: String
)
