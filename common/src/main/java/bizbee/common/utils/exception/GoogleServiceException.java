package bizbee.common.utils.exception;

public class GoogleServiceException extends Exception {

    public GoogleServiceException(String msg) {
        super(msg);
    }

    public GoogleServiceException(Throwable cause) {
        super(cause);
    }
}
