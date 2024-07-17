package scul.projectscul.domain.user.presentation.request
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size


data class LoginRequest(

        @field:NotBlank
        @field:Size(max = 50)
        val email: String,

)
