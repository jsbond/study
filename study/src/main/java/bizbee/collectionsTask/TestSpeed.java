package bizbee.collectionsTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 */
public class TestSpeed {

    private int size = 1_000_000;

    private List<Integer> arrayList = new ArrayList<>();
    private List<Integer> linkedList = new LinkedList<>();
    private Set<Integer> hashSet = new HashSet<>();


    public void testAdd() {
        this.testAdd(this.size);
    }

    public void testAdd(int size) {
        this.size = size;

        System.out.println("test ADD");

        System.out.print("ArrayList: ");
        System.out.println(this.add(new ArrayList()));

        System.out.print("LinkedList: ");
        System.out.println(this.add(new LinkedList()));

        System.out.print("HashSet: ");
        System.out.println(this.add(new HashSet()));
    }

    private long add(Collection collection) {
        long startTime = System.currentTimeMillis();
        for (Integer i = 0; i < size; i++) {
            collection.add(i.toString());
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private void add(int size) {
        for (Integer i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
            hashSet.add(i);
        }
    }

    public void testGet() {
        this.testGet(this.size);
    }

    public void testGet(int size) {
        this.size = size;

        System.out.println("test GET");
        System.out.println("create collections..");
        this.add(size);

        System.out.print("ArrayList(first, 1/2, last): ");
        this.getByList(arrayList, 1);
        this.getByList(arrayList, size / 2);
        this.getByList(arrayList, size-1);

        System.out.print("LinkedList(first, 1/2, last): ");
        this.getByList(linkedList, 1);
        this.getByList(linkedList, size / 2);
        this.getByList(linkedList, size - 1);

    }

    private void getByList(List list, int index) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(index);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }


    public void setSize(int size) {
        this.size = size;
    }
}
