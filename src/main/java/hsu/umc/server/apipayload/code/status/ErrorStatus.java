package hsu.umc.server.apipayload.code.status;

import hsu.umc.server.apipayload.code.ErrorCode;
import hsu.umc.server.apipayload.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements ErrorCode {
    // 가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),
    _NOT_FOUND(HttpStatus.NOT_FOUND, "COMMON404", "요청을 찾을 수 없습니다."),
    //유저 관련 응답
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER4001", "아이디에 해당하는 유저를 찾을 수 없습니다."),
    INVALID_CREDENTIALS(HttpStatus.NOT_FOUND, "USER4002", "유저의 비밀번호가 맞지 않습니다."),
    //질문 관련 응답
    QUESTION_NOT_FOUND(HttpStatus.NOT_FOUND, "QUESTION4001", "아이디에 해당하는 질문을 찾을 수 업습니다."),
    ANSWER_NOT_FOUND(HttpStatus.NOT_FOUND, "ANSWER4001", "아이디에 해당하는 답변을 찾을 수 업습니다.");


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}
