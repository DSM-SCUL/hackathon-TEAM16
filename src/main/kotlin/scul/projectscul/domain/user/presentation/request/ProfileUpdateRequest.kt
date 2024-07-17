package scul.projectscul.domain.user.presentation.request

import javax.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class ProfileUpdateRequest(

        val profileImage: String
)
