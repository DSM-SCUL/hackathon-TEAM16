package scul.projectscul.domain.quiz.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class UserQuizSolved(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val userId: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    val quiz: Quiz,

    @Column(nullable = false)
    val solvedAt: LocalDateTime = LocalDateTime.now()
)
