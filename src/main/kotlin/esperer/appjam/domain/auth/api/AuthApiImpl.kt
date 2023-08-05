package esperer.appjam.domain.auth.api

import esperer.appjam.domain.auth.vo.LoginRequest
import esperer.appjam.domain.auth.vo.TokenResponse
import esperer.appjam.domain.user.constant.UserRole
import esperer.appjam.domain.user.exception.UserNotFoundException
import esperer.appjam.domain.user.persist.User
import esperer.appjam.domain.user.persist.UserJpaRepository
import esperer.appjam.global.security.token.JwtTokenProvider
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthApiImpl(
    private val userRepository: UserJpaRepository,
    private val jwtTokenProvider: JwtTokenProvider
) : AuthApi{

    override fun login(request: LoginRequest): TokenResponse {
        val user = userRepository.findByName(request.name) ?: throw UserNotFoundException()

        val accessToken = jwtTokenProvider.generateAccessToken(user.id)
        val refreshToken = jwtTokenProvider.generateRefreshToken(user.id)

        return TokenResponse(
            accessToken = accessToken,
            refreshToken = refreshToken,
            expiredAt = jwtTokenProvider.accessExpiredTime
        )
    }

    override fun saveUser(name: String) {
        userRepository.save(
            User(
                id = UUID.randomUUID(),
                name = name,
                role = UserRole.ROLE_USER
            )
        )
    }
}