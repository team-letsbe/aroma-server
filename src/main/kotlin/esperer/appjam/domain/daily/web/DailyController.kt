package esperer.appjam.domain.daily.web

import esperer.appjam.domain.daily.api.DailyApi
import esperer.appjam.domain.daily.vo.CreateDailyRequest
import esperer.appjam.domain.daily.vo.DailyCreatedAtRequest
import esperer.appjam.domain.daily.vo.DailyResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/daily")
class DailyController(
    private val dailyApi: DailyApi
) {

    @PostMapping
    fun createDaily(@RequestBody request: CreateDailyRequest): ResponseEntity<String> {
        dailyApi.createDaily(request)
        return ResponseEntity.status(HttpStatus.CREATED).body("데일리 등록 성공")
    }

    @GetMapping
    fun getDailyByCreatedAt(@RequestBody request: DailyCreatedAtRequest): ResponseEntity<DailyResponse> {
        val response = dailyApi.getDailyByCreatedAt(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/all")
    fun getAllDailies(): ResponseEntity<List<DailyResponse>> {
        val responses = dailyApi.getAllDailies()
        return ResponseEntity.ok(responses)
    }

}