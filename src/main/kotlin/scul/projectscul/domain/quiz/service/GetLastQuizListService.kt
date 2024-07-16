package scul.projectscul.domain.quiz.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import scul.projectscul.domain.quiz.domain.repository.QuizRepository
import scul.projectscul.domain.quiz.presentation.response.GetLastSolvedQuizResponse

@Service
@Transactional(readOnly = true)
class GetLastQuizListService (
        private val quizRepository: QuizRepository
) {
/*
    fun execute(): GetLastSolvedQuizResponse {


    }

 */
}
