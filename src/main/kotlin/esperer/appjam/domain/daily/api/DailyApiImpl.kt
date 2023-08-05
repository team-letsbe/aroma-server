package esperer.appjam.domain.daily.api

import esperer.appjam.domain.daily.exception.AlreadyExistsDailyException
import esperer.appjam.domain.daily.exception.DailyNotFoundException
import esperer.appjam.domain.daily.persist.Daily
import esperer.appjam.domain.daily.persist.DailyJpaRepository
import esperer.appjam.domain.daily.vo.CreateDailyRequest
import esperer.appjam.domain.daily.vo.DailyCreatedAtRequest
import esperer.appjam.domain.daily.vo.DailyResponse
import esperer.appjam.global.util.UserUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.util.*

@Service
class DailyApiImpl(
    private val dailyRepository: DailyJpaRepository,
    private val userUtil: UserUtil
) : DailyApi {


    @Transactional
    override fun createDaily(request: CreateDailyRequest) {

        val now = LocalDateTime.now()

        if(dailyRepository.existsByCreatedAt(now))
            throw AlreadyExistsDailyException()

        dailyRepository.save(
            Daily(
                id = UUID.randomUUID(),
                content = request.content,
                emotion = request.emotion,
                createdAt = now,
                user = userUtil.getCurrentUser()
            )
        )
    }

    override fun getDailyByCreatedAt(request: DailyCreatedAtRequest): DailyResponse {
        val daily = dailyRepository.findByCreatedAt(request.createdAt)
            ?: throw DailyNotFoundException()

        return DailyResponse(
            content = daily.content,
            emotion = daily.emotion,
            createdAt = daily.createdAt
        )
    }

    override fun getAllDailies(): List<DailyResponse> {
        val dailies = dailyRepository.findAll()
        return dailies.map {
            DailyResponse(
                content = it.content,
                emotion = it.emotion,
                createdAt = it.createdAt
            )
        }
    }

}