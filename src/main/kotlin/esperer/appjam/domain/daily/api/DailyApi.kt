package esperer.appjam.domain.daily.api

import esperer.appjam.domain.daily.vo.CreateDailyRequest

interface DailyApi {
    fun createDaily(request: CreateDailyRequest)
    fun getDailyByCreatedAt()
}