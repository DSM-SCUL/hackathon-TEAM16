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

        currentUser.todaySolvedCounts + 1

        return GetQuizResponse.of(quiz, currentUser.todaySolvedCounts)
    }
}
