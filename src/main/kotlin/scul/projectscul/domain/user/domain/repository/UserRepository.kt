package scul.projectscul.domain.user.domain.repository

import scul.projectscul.domain.user.domain.User
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface UserRepository : CrudRepository<User, UUID>{

    fun existsByEmail(email: String) : Boolean

    fun findByEmail(email: String) : User?

}