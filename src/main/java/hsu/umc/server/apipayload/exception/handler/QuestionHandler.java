package hsu.umc.server.apipayload.exception.handler;


import hsu.umc.server.apipayload.code.ErrorCode;
import hsu.umc.server.apipayload.exception.GeneralException;

public class QuestionHandler extends GeneralException {

    public QuestionHandler(ErrorCode errorCode) {
        super(errorCode);
    }
}
