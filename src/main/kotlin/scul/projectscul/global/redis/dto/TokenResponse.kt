package scul.projectscul.global.redis.dto

import java.time.LocalDateTime

data class TokenResponse(
    val accessToken: String,
    val accessTokenExp: LocalDateTime,
    val refreshToken: String
)