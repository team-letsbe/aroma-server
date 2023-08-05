package esperer.appjam.domain.daily.vo

import esperer.appjam.domain.daily.constant.Emotion
import java.time.LocalDateTime
import javax.persistence.EnumType
import javax.persistence.Enumerated

data class DailyResponse(
    val content: String,
    @Enumerated(EnumType.STRING)
    val emotion: Emotion,
    val createdAt: LocalDateTime
)
