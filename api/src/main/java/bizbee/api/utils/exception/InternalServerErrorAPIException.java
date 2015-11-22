package bizbee.api.utils.exception;

import bizbee.common.utils.ErrorKey;
import bizbee.common.utils.exception.CommonException;

public class InternalServerErrorAPIException extends APIException {

    public InternalServerErrorAPIException(ErrorKey errorKey, Object... params) {
        super(errorKey, params);
    }

    public InternalServerErrorAPIException(String message, ErrorKey errorKey, Object... params) {
        super(message, errorKey, params);
    }

    public InternalServerErrorAPIException(CommonException e) {
        super(e);
    }
}
