package esperer.appjam.global.error.exception

import esperer.appjam.global.error.ErrorCode

open class GlobalException(val code: ErrorCode) : RuntimeException(code.message)