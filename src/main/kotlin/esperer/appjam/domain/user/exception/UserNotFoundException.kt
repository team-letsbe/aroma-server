package esperer.appjam.domain.user.exception

import esperer.appjam.global.error.ErrorCode
import esperer.appjam.global.error.exception.GlobalException

class UserNotFoundException : GlobalException(ErrorCode.USER_NOT_FOUND)