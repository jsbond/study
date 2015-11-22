package bizbee.exceptionTask;

import java.io.IOException;

/**
 *
 */
public class ExceptionMain {
    public static void main(String[] args) throws TaskException, IOException {
        System.out.println(start());
        System.out.println(0.0/0);
        //FirstExample.start();
    }

    private static int start() {
        try {
            return 1;
        }catch (Exception e) {
            return 2;
        }
        finally {
            return 3;
        }
    }
}
