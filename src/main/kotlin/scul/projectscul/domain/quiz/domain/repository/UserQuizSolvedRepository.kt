package scul.projectscul.domain.quiz.domain.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import scul.projectscul.domain.quiz.domain.UserQuizSolved

interface UserQuizSolvedRepository  : CrudRepository<UserQuizSolved, Long>{
    fun findByUserId(userId: Long): List<UserQuizSolved>
}