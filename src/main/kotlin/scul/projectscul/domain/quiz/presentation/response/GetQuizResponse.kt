package scul.projectscul.domain.quiz.presentation.response

import scul.projectscul.domain.quiz.domain.Quiz

data class GetQuizResponse (
        val quizId: Long,
        val quiz: String,
        val choice1: String,
        val choice2: String,
        val choice3: String,
        val choice4: String,
        val reason: String,
        val todaySolvedQuiz: Int,
        val answer: Int
        ) {
    companion object {
        fun of(quiz: Quiz, todaySolvedQuiz: Int, index : Int) : GetQuizResponse {
            return GetQuizResponse(
                    quizId = quiz.id,
                    quiz = quiz.quiz,
                    choice1 = quiz.choice1,
                    choice2 = quiz.choice2,
                    choice3 = quiz.choice3,
                    choice4 = quiz.choice4,
                    reason = quiz.reason,
                    todaySolvedQuiz = todaySolvedQuiz,
                    answer = index
            )
        }
    }
}
