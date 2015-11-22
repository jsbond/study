package bizbee.annotationTask;

import bizbee.annotationTask.app.Ivan;
import bizbee.annotationTask.app.Jack;
import bizbee.annotationTask.app.Mary;
import bizbee.annotationTask.framework.Bob;
import bizbee.exceptionTask.FirstExample;
import bizbee.exceptionTask.TaskException;

/**
 *
 */
public class AnnotationMain {

    public static void main(String[] args) {
        try {
            startSecondExample();
        }catch (TaskException e) {
            Bob bob = new Bob();
            Jack jack = new Jack();
            Mary mary = new Mary();
            Ivan ivan = new Ivan();

            bob.tellSeeStory(ivan, e);
        }
    }

    private static void startSecondExample() throws TaskException {
        System.err.println("start second example:");
        FirstExample.start();
    }

}
