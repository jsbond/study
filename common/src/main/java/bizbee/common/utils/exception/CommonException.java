package bizbee.common.utils.exception;

import bizbee.common.utils.ErrorKey;
import org.apache.log4j.Logger;

import java.util.Arrays;

public abstract class CommonException extends Exception {
    private static final long serialVersionUID = -2396359047634876880L;
    private Object[] params;
    private String code;
    private boolean showErrorMessage = true;
    private static final Logger logger = Logger.getLogger("apiLogger");

    public CommonException(ErrorKey errorKey, Object... params) {
        super(errorKey.getCode() + " params: " + Arrays.toString(params));
        setParamsAndLog(null, errorKey.getCode(), params);
    }

    public CommonException(String message, ErrorKey errorKey, Object... params) {
        super(message + " "+ errorKey.getCode() + " params: " + Arrays.toString(params));
        setParamsAndLog(message, errorKey.getCode(), params);
    }

    public CommonException(CommonException e) {
        super(e.getCode() + " params: " + Arrays.toString(e.getParams()), e.getCause());
        setParamsAndLog(e.getMessage(), e.getCode(), e.getParams());
    }

    private void setParamsAndLog(String message, String code, Object[] params) {
        this.params = params;
        this.code = code;
        message = message == null ? "" : message;
        logger.error(message + " "+ code + " params: " + Arrays.toString(params));
    }

    public Object[] getParams() {
        return params;
    }

    public String getCode() {
        return code;
    }

    public boolean isShowErrorMessage() {
        return showErrorMessage;
    }

    @Override
    public String toString() {
        return code+super.toString();
    }
}
