package scul.projectscul.domain.solvedQuiz.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import scul.projectscul.domain.solvedQuiz.domain.SolvedQuiz

interface SolvedQuizRepository  : JpaRepository<SolvedQuiz, Long>{

    fun findByUserId(userId: Long): List<SolvedQuiz>

}