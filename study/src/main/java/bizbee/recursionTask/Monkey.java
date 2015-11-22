package bizbee.recursionTask;

/**
 *
 */
public class Monkey {
    private int leafs = 0;

    public void countLeafs(int leafs) {
        this.leafs +=leafs;
        System.out.println(leafs);
    }

    public int getLeafs() {
        return leafs;
    }
}
