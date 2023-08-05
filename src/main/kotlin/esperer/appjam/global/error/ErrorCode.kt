package esperer.appjam.global.error

enum class ErrorCode(
    val message: String,
    val status: Int
) {
    BAD_REQUEST("잘못된 요청", 400),

    UNAUTHORIZED("권한 없음", 401),
    EXPIRED_TOKEN("토큰 만료", 401),
    INVALID_TOKEN("토큰 변질", 401),
    BAD_USER_ROLE_REQUEST("잘못된 유저 역할입니다..", 400),
    FORBIDDEN("금지된 요청입니다.", 403),
    USER_STATE_PENDING("유저가 보류중 입니다.", 403),
    USER_NOT_FOUND("해당 유저를 찾을 수 없습니다.", 404),
    INTERNAL_SERVER_ERROR("서버 내부 에러", 500);
}