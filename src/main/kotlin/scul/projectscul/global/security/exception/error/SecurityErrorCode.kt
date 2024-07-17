package team.aliens.dms.global.security.exception.error

import com.example.kotlinpractice.global.error.exception.ErrorProperty

enum class SecurityErrorCode(
    private val status: Int,
    private val message: String,
    private val sequence: Int
) : ErrorProperty {

    INVALID_TOKEN(401, "Invalid Token", 1),
    EXPIRED_TOKEN(401, "Expired Token", 2),
    UNEXPECTED_TOKEN(401, "Unexpected Token", 3),
    INVALID_ROLE(401, "Invalid Role", 4),

    FORBIDDEN(403, "Can Not Access", 1)
    ;

    override fun status(): Int = status
    override fun message(): String = message
}
