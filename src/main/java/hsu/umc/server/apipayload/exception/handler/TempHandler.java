package hsu.umc.server.apipayload.exception.handler;


import hsu.umc.server.apipayload.code.ErrorCode;
import hsu.umc.server.apipayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(ErrorCode errorCode) {
        super(errorCode);
    }
}
