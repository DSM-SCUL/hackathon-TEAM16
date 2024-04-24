package scul.projectscul.domain.user.presentation.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class SignUpRequest(
        @field:NotBlank
        @field:Size(min = 2, max = 10)
        val name: String,

        @field:NotBlank
        @field:Size(min = 6 ,max = 30)
        val accountId: String,

        @field:NotBlank
        @field:Size(min = 6 ,max = 30)
        val password: String
)
