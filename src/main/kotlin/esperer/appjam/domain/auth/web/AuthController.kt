package esperer.appjam.domain.auth.web

import esperer.appjam.domain.auth.api.AuthApi
import esperer.appjam.domain.auth.vo.LoginRequest
import esperer.appjam.domain.auth.vo.TokenResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authApi: AuthApi
) {

    @PostMapping("/login")
    fun login(request: LoginRequest): ResponseEntity<TokenResponse> {
        val response = authApi.login(request)
        return ResponseEntity.ok(response)
    }



}