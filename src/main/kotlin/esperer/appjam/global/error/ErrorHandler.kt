package esperer.appjam.global.error

import esperer.appjam.global.error.exception.GlobalException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ErrorHandler {

    @ExceptionHandler(GlobalException::class)
    fun handleGlobalException(e: GlobalException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(
            ErrorResponse(e.code),
            HttpStatus.valueOf(e.code.status)
        )
    }
}