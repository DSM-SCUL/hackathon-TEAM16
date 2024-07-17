package scul.projectscul.global.redis.repository

import scul.projectscul.global.redis.domain.RefreshToken
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RefreshTokenRepository: CrudRepository<RefreshToken, String> {
    fun findByToken(token: String): RefreshToken?
}
