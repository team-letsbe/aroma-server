package esperer.appjam.domain.motto.exception

import esperer.appjam.global.error.ErrorCode
import esperer.appjam.global.error.exception.GlobalException

class MottoNotFoundException : GlobalException(ErrorCode.MOTTO_NOT_FOUND)