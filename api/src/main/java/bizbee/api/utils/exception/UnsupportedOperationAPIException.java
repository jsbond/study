package bizbee.api.utils.exception;

import bizbee.common.utils.ErrorKey;

public class UnsupportedOperationAPIException extends APIException {

    public UnsupportedOperationAPIException(ErrorKey errorKey, Object... params) {
        super(errorKey, params);
    }

    public UnsupportedOperationAPIException(String message, ErrorKey errorKey, Object... params) {
        super(message, errorKey, params);
    }
}
