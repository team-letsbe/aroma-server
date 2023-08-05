package esperer.appjam.domain.motto.web

import esperer.appjam.domain.motto.api.MottoApi
import esperer.appjam.domain.motto.vo.CreateMottoRequest
import esperer.appjam.domain.motto.vo.MottoResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/motto")
class MottoController(
    private val mottoApi: MottoApi
) {

    @PostMapping("/")
    fun createMotto(@RequestBody request: CreateMottoRequest): ResponseEntity<String> {
        mottoApi.createMotto(request)
        return ResponseEntity.status(HttpStatus.CREATED).body("motto 등록 성공")
    }

    @GetMapping("/random")
    fun getRandomMotto(): ResponseEntity<MottoResponse> {
        val response = mottoApi.getRandomMotto()
        return ResponseEntity.ok(response)
    }

}