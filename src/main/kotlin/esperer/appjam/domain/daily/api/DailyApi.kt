package esperer.appjam.domain.daily.api

import esperer.appjam.domain.daily.vo.CreateDailyRequest
import esperer.appjam.domain.daily.vo.DailyCreatedAtRequest
import esperer.appjam.domain.daily.vo.DailyResponse

interface DailyApi {
    fun createDaily(request: CreateDailyRequest)
    fun getDailyByCreatedAt(request: DailyCreatedAtRequest): DailyResponse
}