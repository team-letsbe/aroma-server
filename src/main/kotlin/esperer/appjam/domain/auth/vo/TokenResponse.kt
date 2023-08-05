package esperer.appjam.domain.auth.vo

import java.time.LocalDateTime

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
    val expiredAt: LocalDateTime
)