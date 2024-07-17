package scul.projectscul.domain.solvedQuiz.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import scul.projectscul.domain.solvedQuiz.domain.SolvedQuiz
import java.util.UUID

interface SolvedQuizRepository  : JpaRepository<SolvedQuiz, Long>{

    fun findByUserId(userId: UUID): List<SolvedQuiz>

}