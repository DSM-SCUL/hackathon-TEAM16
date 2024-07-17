package scul.projectscul.domain.solvedQuiz.presentation.response

import java.time.LocalDateTime

data class GetLastSolvedQuizResponse(
        val quizzes: List<QuizDto>
) {
        data class QuizDto(
                val id: Long,
                val quiz: String,
                val answer: String,
                val choice1: String,
                val choice2: String,
                val choice3: String,
                val choice4: String,
                val reason: String,
                val solvedAt: LocalDateTime
        )
}