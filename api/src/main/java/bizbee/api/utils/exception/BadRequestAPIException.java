package bizbee.api.utils.exception;


import bizbee.common.utils.ErrorKey;
import bizbee.common.utils.exception.CommonException;

public class BadRequestAPIException extends APIException {

    public BadRequestAPIException(ErrorKey errorKey, Object... params) {
        super(errorKey, params);
    }

    public BadRequestAPIException(String message, ErrorKey errorKey, Object... params) {
        super(message, errorKey, params);
    }

    public BadRequestAPIException(CommonException e) {
        super(e);
    }
}
