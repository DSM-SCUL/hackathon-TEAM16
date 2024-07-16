package scul.projectscul.domain.quiz.domain.repository

import org.springframework.data.repository.CrudRepository
import scul.projectscul.domain.user.domain.User
import java.util.*

interface QuizRepository : CrudRepository<User, UUID> {
}