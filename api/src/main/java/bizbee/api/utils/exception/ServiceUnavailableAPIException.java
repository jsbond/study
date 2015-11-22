package bizbee.api.utils.exception;

import bizbee.common.utils.ErrorKey;

public class ServiceUnavailableAPIException extends APIException {

    public ServiceUnavailableAPIException(ErrorKey errorKey, Object... params) {
        super(errorKey, params);
    }

    public ServiceUnavailableAPIException(String message, ErrorKey errorKey, Object... params) {
        super(message, errorKey, params);
    }
}
