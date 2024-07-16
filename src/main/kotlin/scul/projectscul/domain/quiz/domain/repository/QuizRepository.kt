package scul.projectscul.domain.quiz.domain.repository

import org.springframework.data.repository.CrudRepository
import scul.projectscul.domain.quiz.domain.Quiz
import java.util.*

interface QuizRepository : CrudRepository<Quiz, UUID> {
    fun findQuizById(quizId: Long) : Quiz
}