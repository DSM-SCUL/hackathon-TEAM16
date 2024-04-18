package scul.projectscul.domain.user.presentation.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class LoginRequest(

        @field:NotBlank
        @field:Size(max = 30)
        val accountId: String,

        @field:NotBlank
        @field:Size(max = 30)
        val password: String
)
