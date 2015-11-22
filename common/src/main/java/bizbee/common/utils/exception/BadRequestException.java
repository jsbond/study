package bizbee.common.utils.exception;


import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    private static final Logger logger = Logger.getLogger("apiLogger");

    public BadRequestException(String msg) {
        super(msg);
        logger.error(msg);
    }

    public BadRequestException(Exception ex) {
        super(ex);
    }

    public BadRequestException(String msg, Throwable cause) {
        super(msg, cause);
    }
}