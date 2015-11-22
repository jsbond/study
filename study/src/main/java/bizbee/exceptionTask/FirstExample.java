package bizbee.exceptionTask;

/**
 *
 */
public class FirstExample {

    public static void start() throws TaskException{
        first();
    }

    private static void first() throws TaskException{
        int examplePart = 0;                            //TODO second, third, fourth
        System.err.println(". 10m down");

        switch(examplePart) {
            case 0: {
                second();
                break;
            }
            case 1: {
                secondWithCatch();
                break;
            }
            case 2: {
                secondWithErrorInCatch();
                break;
            }
            case 3: {
                secondWithFinally();
                break;
            }
            default: second();
        }

        System.err.println(". 10m up");
    }

    private static void second() throws TaskException {
        System.err.println(". . 25m down");
        third();
        System.err.println(". . 25m up");
    }

    private static void third() throws TaskException {
        System.err.println(". . . 50m down");

        if (true) {
            final String whatWeSee = "shark";                                //TODO first
            switch(whatWeSee) {
                case "pearl": {
                    System.err.println(". . . 50m RETURN, ALL GOOD");
                    break;
                }
                case "shark": {
                    System.err.println(". . . 50m SHARK THERE!!");
                    throw new TaskException(". . . 50m SHARK THERE!!");
                }
            }
        }
        System.err.println(". . . 50m up");
    }

    private static void secondWithCatch() throws TaskException {
        try {

            System.err.println(". . 25m down");
            third();

        }catch (TaskException e) {
            System.err.println(". . 25m SHARK SWAM AWAY!!");
        }catch (Exception e) {
            System.err.print(". . 25m SHARK IS NEAR!!");
        }
        System.err.println(". . 25m up");
    }

    private static void secondWithErrorInCatch() throws TaskException {
        try {
            System.err.println(". . 25m down");
            third();

        }catch (TaskException e) {
            System.err.println(". . 25m SHARK SWAM AWAY!!");
            if (true) {
                System.err.println(". . 25m OCTOPUS THERE!!");
                throw new TaskException(e +  ". . 25m OCTOPUS THERE!!");
            }
        }
        System.err.println(". . 25m up");
    }

    private static void secondWithFinally() throws TaskException {
        try {
            System.err.println(". . 25m down");
            third();

        }catch (TaskException e) {
            System.err.println(". . 25m SHARK SWAM AWAY!!");
            if (true) {
                System.err.println(". . 25m OCTOPUS THERE!!");
                throw new TaskException(e +  ". . 25m OCTOPUS THERE!!");
            }
        }finally {
            System.err.println(". . 25m OCTOPUS IS NEAR!!");
        }
        System.err.println(". . 25m up");
    }
}
