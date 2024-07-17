package scul.projectscul.domain.solvedQuiz.presentation.response

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class GetLastSolvedQuizResponse(
        val quizzesByDate: Map<String, List<QuizDto>>
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

        companion object {
                fun fromQuizList(quizzes: List<QuizDto>): GetLastSolvedQuizResponse {
                        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                        val quizzesByDate = quizzes.sortedByDescending { it.solvedAt }
                                .groupBy { it.solvedAt.format(formatter) }
                        return GetLastSolvedQuizResponse(quizzesByDate)
                }
        }
}
