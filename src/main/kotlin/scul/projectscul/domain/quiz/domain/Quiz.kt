package scul.projectscul.domain.quiz.domain

import com.example.kotlinpractice.global.entity.BaseUUIDEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import java.util.*

@Entity
class Quiz(
        id : UUID?,

        @Column(columnDefinition = "VARCHAR(1000)", nullable = false)
        val quiz: String,

        @Column(columnDefinition = "VARCHAR(100)", nullable = false)
        val answer: String,

        @Column(columnDefinition = "VARCHAR(50)", nullable = false)
        val choice1: String,

        @Column(columnDefinition = "VARCHAR(50)", nullable = false)
        val choice2: String,

        @Column(columnDefinition = "VARCHAR(50)", nullable = false)
        val choice3: String,

        @Column(columnDefinition = "VARCHAR(50)", nullable = false)
        val choice4: String,

        val isSolved: Boolean = false ,

        ) : BaseUUIDEntity(id)