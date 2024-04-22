package scul.projectscul.domain.bookmark.domain

import java.io.Serializable
import java.util.*

data class BookMarkId(
        val user: UUID?,
        val culture: UUID?
) : Serializable {
    companion object {
        private const val serialVersionUID = 1L
    }
}