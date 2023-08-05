package esperer.appjam.domain.daily.vo

import esperer.appjam.domain.daily.constant.Emotion
import javax.persistence.EnumType
import javax.persistence.Enumerated

data class CreateDailyRequest(
    val content: String,
    @Enumerated(EnumType.STRING)
    val emotion: Emotion
)
