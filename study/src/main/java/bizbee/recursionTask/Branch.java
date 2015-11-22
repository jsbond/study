package bizbee.recursionTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 */
public class Branch {
    private Branch parent;
    private int leafs = new Random().nextInt(20);
    private List<Branch> branches = new ArrayList<>();

    public Branch(int leafs) {
        this.leafs = leafs;
    }

    public void run(Monkey monkey) {
        monkey.countLeafs(leafs);
        for (Branch branch: this.getBranches()) {
            if (branch.getBranches() != null) {
                branch.run(monkey);
            }
        }
    }

    public Branch getParent() {
        return parent;
    }

    public void setParent(Branch parent) {
        this.parent = parent;
    }

    public int getLeafs() {
        return leafs;
    }

    public void setLeafs(int leafs) {
        this.leafs = leafs;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }
}
