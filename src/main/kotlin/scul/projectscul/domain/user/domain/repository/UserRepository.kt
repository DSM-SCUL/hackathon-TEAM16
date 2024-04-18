package scul.projectscul.domain.user.domain.repository

import scul.projectscul.domain.user.domain.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long>{

    fun existsByAccountId(accountId: String) : Boolean

    fun findByAccountId(accountId: String) : User

}