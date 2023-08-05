package esperer.appjam.domain.motto.api

import esperer.appjam.domain.motto.vo.CreateMottoRequest
import esperer.appjam.domain.motto.vo.MottoResponse

interface MottoApi {
    fun createMotto(request: CreateMottoRequest)
    fun getRandomMotto(): MottoResponse
}