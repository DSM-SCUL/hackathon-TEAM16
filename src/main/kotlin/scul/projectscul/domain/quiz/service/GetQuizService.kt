package scul.projectscul.domain.quiz.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import scul.projectscul.domain.quiz.domain.Quiz
import scul.projectscul.domain.quiz.domain.repository.QuizRepository
import scul.projectscul.domain.quiz.presentation.response.GetQuizResponse
import scul.projectscul.domain.user.domain.User
import scul.projectscul.domain.user.facade.UserFacade

@Service
@Transactional(readOnly = true)
class GetQuizService (
        private val userFacade: UserFacade,
        private val quizRepository: QuizRepository
) {

    fun execute(quizId: Long): GetQuizResponse {

        val currentUser: User = userFacade.getCurrentUser()
        val quiz: Quiz = quizRepository.findQuizById(quizId)

        var index : Int =0

        when (quiz.answer) {
            quiz.choice1 -> {
                index = 1
            }
            quiz.choice2 -> {
                index = 2
            }
            quiz.choice3 -> {
                index = 3
            }
            quiz.choice4 -> {
                index = 4
            }
        }

        return GetQuizResponse.of(quiz, currentUser.todaySolvedCounts, index)
    }
}
