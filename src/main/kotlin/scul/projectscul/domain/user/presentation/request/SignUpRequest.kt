package scul.projectscul.domain.user.presentation.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class SignUpRequest(
        @field:NotBlank
        @field:Size(max = 40)
        val name: String,

        @field:NotBlank
        @field:Size(max = 10)
        val accountId: String,

        @field:NotBlank
        @field:Size(max = 25)
        val password: String
)
