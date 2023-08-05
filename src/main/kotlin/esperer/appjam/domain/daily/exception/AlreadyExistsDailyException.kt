package esperer.appjam.domain.daily.exception

import esperer.appjam.global.error.ErrorCode
import esperer.appjam.global.error.exception.GlobalException

class AlreadyExistsDailyException : GlobalException(ErrorCode.ALREADY_EXIST_DAILY)