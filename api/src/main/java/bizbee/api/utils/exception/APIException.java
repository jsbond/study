package bizbee.api.utils.exception;


import bizbee.common.utils.ErrorKey;
import bizbee.common.utils.exception.CommonException;

public abstract class APIException extends CommonException {

    public APIException(ErrorKey errorKey, Object... params) {
        super(errorKey, params);
    }

    public APIException(String message, ErrorKey errorKey, Object... params) {
        super(message, errorKey, params);
    }

    public APIException(CommonException e) {
        super(e);
    }
}
