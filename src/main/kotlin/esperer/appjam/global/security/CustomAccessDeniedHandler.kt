package esperer.appjam.global.security

import com.fasterxml.jackson.databind.ObjectMapper
import esperer.appjam.global.error.ErrorCode
import esperer.appjam.global.error.ErrorResponse
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class CustomAccessDeniedHandler(
    private val objectMapper: ObjectMapper
) : AccessDeniedHandler {

    private val log = LoggerFactory.getLogger(this::class.simpleName)

    override fun handle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        accessDeniedException: AccessDeniedException
    ) {
        log.error("=====ACCESS DENIED=====")
        val errorCode = ErrorCode.FORBIDDEN
        val responseString = objectMapper.writeValueAsString(ErrorResponse(errorCode.message, errorCode.status))
        response.characterEncoding = "UTF-8"
        response.status = errorCode.status
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(responseString)
    }
}