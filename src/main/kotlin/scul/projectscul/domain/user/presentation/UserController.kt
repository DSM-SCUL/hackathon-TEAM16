package scul.projectscul.domain.user.presentation

import scul.projectscul.domain.user.presentation.request.SignUpRequest
import scul.projectscul.domain.user.service.SignUpService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/user")
@RestController
class UserController (
        private val signUpService: SignUpService
) {
    @PostMapping
    fun signUp(@RequestBody request : SignUpRequest) {
        signUpService.execute(request)
    }

}
