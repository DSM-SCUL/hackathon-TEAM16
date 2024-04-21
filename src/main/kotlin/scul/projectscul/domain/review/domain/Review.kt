package scul.projectscul.domain.review.domain

import com.example.kotlinpractice.global.entity.BaseEntity
import jakarta.persistence.*
import scul.projectscul.domain.culture.domain.Culture
import scul.projectscul.domain.user.domain.User

@Entity
class Review (
        id: Long,

        @Column(columnDefinition = "VARCHAR(100)", nullable = false)
        val title: String,

        @Column(columnDefinition = "VARCHAR(1000)", nullable = false)
        val content: String,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "culture_id", columnDefinition = "BIGINT", nullable = false)
        val culture: Culture,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", columnDefinition = "BIGINT", nullable = false)
        val user: User

) : BaseEntity(id)