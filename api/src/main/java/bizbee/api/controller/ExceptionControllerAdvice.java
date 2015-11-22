package bizbee.api.controller;

import bizbee.api.response.APIError;
import bizbee.api.utils.exception.APIException;
import bizbee.api.utils.exception.BadRequestAPIException;
import bizbee.common.utils.exception.CommonException;
import bizbee.api.utils.exception.ServiceUnavailableAPIException;
import bizbee.api.utils.exception.UnsupportedOperationAPIException;
import bizbee.common.utils.Constants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.MessageFormat;
import java.util.Map;

@ControllerAdvice
public class ExceptionControllerAdvice {

    private static final Logger logger = Logger.getLogger(ExceptionControllerAdvice.class);
    private static final String MALFORMED_INPUT_JSON_CODE = "malformed.input.json";
    private static final String ACCESS_IS_DENIED = "access.is.denied";

    @Value("#{errorProps}")
    private Map<String, String> errorProps;

    @SuppressWarnings("unused")
    @ExceptionHandler({BadRequestAPIException.class, UnsupportedOperationAPIException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public APIError handleBadRequestExceptions(APIException e, HttpServletRequest request, HttpServletResponse resp) throws Exception {
        String message = extractMessageFromAPIException(e);
        return handleException(e, message, message);
    }

    @SuppressWarnings("unused")
    @ExceptionHandler(ServiceUnavailableAPIException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public APIError handleInternalServerErrorExceptions(ServiceUnavailableAPIException e, HttpServletRequest request, HttpServletResponse resp) throws Exception {
        String message = extractMessageFromAPIException(e);
        return handleException(e, message, message);
    }

    @SuppressWarnings("unused")
    @ExceptionHandler(ServletException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public APIError handleServletException(ServletException e, HttpServletRequest request, HttpServletResponse resp) throws Exception {
        String message = e.getMessage();
        return handleException(e, message, message);
    }

    @SuppressWarnings("unused")
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public APIError handleHttpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest request, HttpServletResponse resp) throws Exception {
        String message = this.errorProps.get(MALFORMED_INPUT_JSON_CODE);
       return handleException(e, message, e.getMessage());
    }

    @SuppressWarnings("unused")
    @ExceptionHandler(CommonException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public APIError handleException(CommonException e, HttpServletRequest request, HttpServletResponse resp) throws Exception {
        String message = Constants.DEFAULT_ERROR_MESSAGE;

        if(e.isShowErrorMessage()) message = extractMessageFromAPIException(e);

        return handleException(e, message, e.getMessage());
    }

    @SuppressWarnings("unused")
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public APIError handleException(AccessDeniedException e, HttpServletRequest request, HttpServletResponse resp) throws Exception {
        String message = this.errorProps.get(ACCESS_IS_DENIED);
        return handleException(e, message, e.getMessage());
    }

    private APIError handleException(Exception e, String message, String exceptionMessage) {
        logger.error(exceptionMessage, e);
        return new APIError(message);
    }

    private String extractMessageFromAPIException(CommonException e) {
        String code = e.getCode();
        String message = this.errorProps.get(code);
        if (message == null) {
            logger.error("Not found message for exception code : " + code);
            message = Constants.DEFAULT_ERROR_MESSAGE;
        } else {
            Object[] params = e.getParams();
            message = MessageFormat.format(message, params);
        }
        return message;
    }
}
