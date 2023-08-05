package esperer.appjam.domain.daily.exception

import esperer.appjam.global.error.ErrorCode
import esperer.appjam.global.error.exception.GlobalException

class DailyNotFoundException : GlobalException(ErrorCode.DAILY_NOT_FOUND)