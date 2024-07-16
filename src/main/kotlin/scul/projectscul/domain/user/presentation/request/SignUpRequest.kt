package scul.projectscul.domain.user.presentation.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import java.time.LocalDate
import java.time.LocalDateTime

data class SignUpRequest(

        @field:NotBlank
        @field:Size(min = 2, max = 10)
        val name: String,

        @field:NotBlank
        @field:Size(min = 8, max = 50)
        val email: String,

        @field:NotBlank
        val birth: LocalDate,

        @field:NotBlank
        val profileImage: String
)
