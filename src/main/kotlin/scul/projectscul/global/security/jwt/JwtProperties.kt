package scul.projectscul.global.security.jwt

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class JwtProperties(
        @Value("\${jwt.header}") val header: String,
        @Value("\${jwt.prefix}") val prefix: String,
        @Value("\${jwt.secret-key}") val secretKey: String,
        @Value("\${jwt.access-exp}") val accessExp: Long,
        @Value("\${jwt.refresh-exp}") val refreshExp: Long
)
