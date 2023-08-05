package esperer.appjam.global.filter

import com.fasterxml.jackson.databind.ObjectMapper
import esperer.appjam.global.error.ErrorCode
import esperer.appjam.global.error.ErrorResponse
import esperer.appjam.global.error.exception.GlobalException
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.JwtException
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ExceptionFilter : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        runCatching {
            filterChain.doFilter(request, response)
        }.onFailure { e ->
            when(e) {
                is ExpiredJwtException -> exceptionToResponse(ErrorCode.EXPIRED_TOKEN, response)
                is JwtException -> exceptionToResponse(ErrorCode.INVALID_TOKEN, response)
                is GlobalException -> exceptionToResponse(e.code, response)
            }
        }
    }

    private fun exceptionToResponse(errorCode: ErrorCode, response: HttpServletResponse) {
        response.status = errorCode.status
        response.contentType = "application/json"
        response.characterEncoding = "utf-8"
        val errorResponse = ErrorResponse(errorCode.message, errorCode.status)
        val errorResponseToJson = ObjectMapper().writeValueAsString(errorResponse)
        response.writer.write(errorResponseToJson)
    }
}