package esperer.appjam.domain.auth.api

import esperer.appjam.domain.auth.vo.LoginRequest
import esperer.appjam.domain.auth.vo.TokenResponse

interface AuthApi {
    fun login(request: LoginRequest): TokenResponse
    fun saveUser(name: String)

}