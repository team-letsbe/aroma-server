package esperer.appjam.domain.daily.api

import esperer.appjam.domain.daily.persist.Daily
import esperer.appjam.domain.daily.persist.DailyJpaRepository
import esperer.appjam.domain.daily.vo.CreateDailyRequest
import java.time.LocalDateTime
import java.util.*

class DailyApiImpl(
    private val dailyRepository: DailyJpaRepository
) : DailyApi {


    override fun createDaily(request: CreateDailyRequest) {
        Daily(
            id = UUID.randomUUID(),
            content = request.content,
            emotion = request.emotion,
            createdAt = LocalDateTime.now(),
            user =
        )
    }

    override fun getDailyByCreatedAt() {
        TODO("Not yet implemented")
    }

}