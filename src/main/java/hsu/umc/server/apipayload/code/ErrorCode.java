package hsu.umc.server.apipayload.code;

public interface ErrorCode {
    public ErrorReasonDTO getReason();

    public ErrorReasonDTO getReasonHttpStatus();
}
