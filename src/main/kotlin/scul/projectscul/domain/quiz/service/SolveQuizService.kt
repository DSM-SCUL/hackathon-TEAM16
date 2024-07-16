package scul.projectscul.domain.quiz.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import scul.projectscul.domain.quiz.domain.Quiz
import scul.projectscul.domain.quiz.domain.repository.QuizRepository
import scul.projectscul.domain.quiz.presentation.request.SolveQuizRequest
import scul.projectscul.domain.user.domain.User
import scul.projectscul.domain.user.facade.UserFacade

@Service
@Transactional
class SolveQuizService (
        private val userFacade: UserFacade,
        private val quizRepository: QuizRepository
) {

    fun execute(request: SolveQuizRequest, quizId: Long) {

        val currentUser: User = userFacade.getCurrentUser()
        val quiz: Quiz = quizRepository.findQuizById(quizId)

        if (request.answer == quiz.answer) {
            val randomValue = (Math.random()) * (16 - 9) + 8
            currentUser.score + randomValue

            currentUser.SolvedCounts+1
        }
    }
}