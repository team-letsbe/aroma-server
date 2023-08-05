package esperer.appjam.global.security.exception

import esperer.appjam.global.error.ErrorCode
import esperer.appjam.global.error.exception.GlobalException

class ExpiredTokenException : GlobalException(ErrorCode.EXPIRED_TOKEN)