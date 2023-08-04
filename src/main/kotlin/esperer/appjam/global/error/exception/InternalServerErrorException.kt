package esperer.appjam.global.error.exception

import esperer.appjam.global.error.ErrorCode

class InternalServerErrorException : GlobalException(ErrorCode.INTERNAL_SERVER_ERROR)