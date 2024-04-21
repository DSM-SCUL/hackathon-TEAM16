package scul.projectscul.domain.bookmark.domain

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import scul.projectscul.domain.culture.domain.Culture
import scul.projectscul.domain.user.domain.User

@Entity
class BookMark (

        @Id
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
        val user: User?,

        @Id
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "culture_id", columnDefinition = "BINARY(16)", nullable = false)
        val culture: Culture?,
)
