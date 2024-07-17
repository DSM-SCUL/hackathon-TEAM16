package scul.projectscul.domain.solvedQuiz.domain

import scul.projectscul.domain.quiz.domain.Quiz
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.*

@Entity
class SolvedQuiz(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(nullable = false)
    val userId: UUID?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    val quiz: Quiz,

    @Column(nullable = false)
    val solvedAt: LocalDateTime = LocalDateTime.now()
)
