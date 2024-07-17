package scul.projectscul.domain.quiz.domain

import com.example.kotlinpractice.global.entity.BaseUUIDEntity
import javax.persistence.*

@Entity
class Quiz(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id : Long,

        @Column(columnDefinition = "VARCHAR(1000)")
        val quiz: String,

        @Column(columnDefinition = "VARCHAR(100)")
        val answer: String,

        @Column(columnDefinition = "VARCHAR(50)")
        val choice1: String,

        @Column(columnDefinition = "VARCHAR(50)")
        val choice2: String,

        @Column(columnDefinition = "VARCHAR(50)")
        val choice3: String,

        @Column(columnDefinition = "VARCHAR(50)")
        val choice4: String,

        @Column(columnDefinition = "VARCHAR(500)")
        val reason: String

)