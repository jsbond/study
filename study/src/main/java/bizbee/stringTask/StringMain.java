package bizbee.stringTask;

/**
 *
 */
public class StringMain {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        String s1 = "Hello!";
        String s2 = "Hello!";
        System.out.println("equals: " + s1.equals(s2));
        System.out.println("s1=s2: " + (s1 == s2));

        String t1 = "Hello!" + time;
        String t2 = "Hello!" + time;
        System.out.println("t1=t2: " + (t1 == t2));

        Integer i1 = 200;
        Integer i2 = 200;



        System.out.println(i1 == i2);
    }





}
