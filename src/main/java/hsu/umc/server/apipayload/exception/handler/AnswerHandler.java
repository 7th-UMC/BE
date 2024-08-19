package hsu.umc.server.apipayload.exception.handler;

import hsu.umc.server.apipayload.code.ErrorCode;
import hsu.umc.server.apipayload.exception.GeneralException;

public class AnswerHandler extends GeneralException {
    public AnswerHandler(ErrorCode errorCode) {
        super(errorCode);
    }
}
