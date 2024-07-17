package scul.projectscul.domain.user.presentation

import org.springframework.web.bind.annotation.GetMapping
import scul.projectscul.domain.user.presentation.request.SignUpRequest
import scul.projectscul.domain.user.service.SignUpService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import scul.projectscul.domain.user.presentation.request.EmailCheckRequest
import scul.projectscul.domain.user.presentation.request.LoginRequest
import scul.projectscul.domain.user.presentation.response.MyPageResponse
import scul.projectscul.domain.user.service.EmailCheckService
import scul.projectscul.domain.user.service.LoginService
import scul.projectscul.domain.user.service.MyPageService
import scul.projectscul.global.redis.dto.TokenResponse

@RequestMapping("/scul/users")
@RestController
class UserController (
        private val signUpService: SignUpService,
        private val loginService: LoginService,
        private val myPageService: MyPageService,
        private val emailCheckService: EmailCheckService
) {
    @PostMapping("/signup")
    fun signUp(@RequestBody request: SignUpRequest) : TokenResponse{
        return signUpService.execute(request)
    }

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest) : TokenResponse{
        return loginService.execute(request)
    }

    @GetMapping("/mypage")
    fun mypage() : MyPageResponse {
        return myPageService.execute()
    }

    @GetMapping("/email")
    fun emailCheck(request: EmailCheckRequest) : Boolean {
        return emailCheckService.execute(request)
    }
}
