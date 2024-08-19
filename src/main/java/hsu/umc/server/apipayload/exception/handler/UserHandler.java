package hsu.umc.server.apipayload.exception.handler;

import hsu.umc.server.apipayload.code.ErrorCode;
import hsu.umc.server.apipayload.exception.GeneralException;

public class UserHandler extends GeneralException {
    public UserHandler(ErrorCode errorCode) {
        super(errorCode);
    }
}
