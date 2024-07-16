package scul.projectscul.domain.quiz.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import scul.projectscul.domain.quiz.domain.repository.UserQuizSolvedRepository
import scul.projectscul.domain.quiz.presentation.response.GetLastSolvedQuizResponse

@Service
@Transactional(readOnly = true)
class GetLastQuizListService(
        private val userQuizSolveRepository: UserQuizSolvedRepository
) {
        fun execute(userId: Long): GetLastSolvedQuizResponse {
                val solvedQuizzes = userQuizSolveRepository.findByUserId(userId)

                return GetLastSolvedQuizResponse(
                        quizzes = solvedQuizzes.map { userQuizSolve ->
                                GetLastSolvedQuizResponse.QuizDto(
                                        id = userQuizSolve.quiz.id,
                                        quiz = userQuizSolve.quiz.quiz,
                                        answer = userQuizSolve.quiz.answer,
                                        choice1 = userQuizSolve.quiz.choice1,
                                        choice2 = userQuizSolve.quiz.choice2,
                                        choice3 = userQuizSolve.quiz.choice3,
                                        choice4 = userQuizSolve.quiz.choice4,
                                        reason = userQuizSolve.quiz.reason,
                                        solvedAt = userQuizSolve.solvedAt
                                )
                        }
                )
        }
}