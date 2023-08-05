package esperer.appjam.global.error

enum class ErrorCode(
    val message: String,
    val status: Int
) {
    BAD_REQUEST("잘못된 요청", 400),

    UNAUTHORIZED("권한 없음", 401),
    EXPIRED_TOKEN("토큰 만료", 401),
    INVALID_TOKEN("토큰 변질", 401),
    FORBIDDEN("금지된 요청입니다.", 403),
    USER_NOT_FOUND("해당 유저를 찾을 수 없습니다.", 404),
    DAILY_NOT_FOUND("찾을 수 없는 데일리입니다.", 404),
    ALREADY_EXIST_DAILY("이미 존재하는 데일리입니다.", 401),
    MOTTO_NOT_FOUND("찾을 수 없는 명인입니다.", 404),
    INTERNAL_SERVER_ERROR("서버 내부 에러", 500);
}