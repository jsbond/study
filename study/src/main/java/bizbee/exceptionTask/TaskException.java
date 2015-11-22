package bizbee.exceptionTask;

import org.apache.log4j.Logger;

import java.util.Arrays;


/**
 *
 */
public class TaskException extends Exception {
    private static final Logger logger = Logger.getLogger(TaskException.class);

    public TaskException(final String message) {
        super(message);
        logger.info(message);
    }

    public TaskException(final String message, final Object... params) {
        super(message + " " + Arrays.toString(params));
    }

    public TaskException(final TaskException e, final String message) {
        super(e.getMessage());
    }

}
