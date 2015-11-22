package bizbee.recursionTask;

/**
 *
 */
public class RecursionMain {

    public static void main(String[] args) {
        Branch first = new Branch(3);
        Branch firstFirst = new Branch(5);
        Branch firstSecond = new Branch(12);
        Branch firstFirstFirst = new Branch(6);

        first.getBranches().add(firstFirst);
        first.getBranches().add(firstSecond);
        firstFirst.getBranches().add(firstFirstFirst);

        Monkey monkey = new Monkey();

        first.run(monkey);
        System.out.println("----------" + monkey.getLeafs());

    }
}
