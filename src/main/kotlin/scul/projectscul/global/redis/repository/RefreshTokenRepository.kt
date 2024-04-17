package scul.projectscul.global.redis.repository

import scul.projectscul.global.redis.domain.RefreshToken
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository: CrudRepository<RefreshToken, String> {
    fun findByToken(token: String): RefreshToken?
}
