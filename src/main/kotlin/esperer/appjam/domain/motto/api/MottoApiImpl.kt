package esperer.appjam.domain.motto.api

import esperer.appjam.domain.motto.exception.MottoNotFoundException
import esperer.appjam.domain.motto.persist.Motto
import esperer.appjam.domain.motto.persist.MottoJpaRepository
import esperer.appjam.domain.motto.vo.CreateMottoRequest
import esperer.appjam.domain.motto.vo.MottoResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
@Transactional
class MottoApiImpl(
    private val mottoRepository: MottoJpaRepository
) : MottoApi {

    override fun createMotto(request: CreateMottoRequest) {
        mottoRepository.save(
            Motto(
                content = request.content,
                createdBy = request.createdBy
            )
        )
    }

    override fun getRandomMotto(): MottoResponse {
        val motto = mottoRepository.findRandomMotto()
            ?: throw MottoNotFoundException()
        return MottoResponse(
            content = motto.content,
            createdBy = motto.createdBy
        )
    }

}