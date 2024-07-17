package scul.projectscul.global.redis.dto

data class TokenResponse(
        val accessToken: String,
        val accessTokenExp: Long,
)