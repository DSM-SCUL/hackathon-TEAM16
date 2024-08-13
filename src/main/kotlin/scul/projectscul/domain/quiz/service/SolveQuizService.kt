package scul.projectscul.domain.quiz.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import scul.projectscul.domain.quiz.domain.Quiz
import scul.projectscul.domain.quiz.domain.repository.QuizRepository
import scul.projectscul.domain.quiz.exception.TodayQuizOverException
import scul.projectscul.domain.quiz.presentation.request.SolveQuizRequest
import scul.projectscul.domain.solvedQuiz.domain.SolvedQuiz
import scul.projectscul.domain.solvedQuiz.domain.repository.SolvedQuizRepository
import scul.projectscul.domain.user.domain.Enum.Tier
import scul.projectscul.domain.user.domain.User
import scul.projectscul.domain.user.facade.UserFacade

@Service
@Transactional
class SolveQuizService (
        private val userFacade: UserFacade,
        private val quizRepository: QuizRepository,
        private val solvedQuizRepository: SolvedQuizRepository
) {

    fun execute(request: SolveQuizRequest, quizId: Long) : Boolean {

        val currentUser: User = userFacade.getCurrentUser()
        val quiz: Quiz = quizRepository.findQuizById(quizId)

        var correct: Boolean = false

        if (request.answer == quiz.answer) {
            val randomValue = (Math.random() * (500 - 300)) + 300
            currentUser.score + randomValue.toInt()

            when (currentUser.score) {
                0 -> {
                    currentUser.tier = Tier.UNRANKED
                }
                in 1..500 -> {
                    currentUser.tier = Tier.BRONZE
                }
                in 501..1100 -> {
                    currentUser.tier = Tier.SILVER
                }
                in 1101..1800 -> {
                    currentUser.tier = Tier.GOLD
                }
                in 1801..2600 -> {
                    currentUser.tier = Tier.PLATINUM
                }
                in 2601..3700 -> {
                    currentUser.tier = Tier.DIAMOND
                }
                in 3701..4700 -> {
                    currentUser.tier = Tier.RUBY
                }
                in 4701..6000 -> {
                    currentUser.tier = Tier.SUN
                }
                else -> {
                    currentUser.tier = Tier.SUN
                }
            }

            currentUser.solvedCounts + 1

            val solvedQuiz = SolvedQuiz(
                id = 0,
                userId = currentUser.id,
                quiz = quiz
            )

            solvedQuizRepository.save(solvedQuiz)
            correct = true

        }
        return correct

    }
}
