package bizbee.collectionsTask;

/**
 *
 */
public class ListMain {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("Q");
//        list.add("Q");
//        list.add("AAA");
//        list.add("ZZ");
//        System.out.println(list);
//
//        Comparator<String> comparator =  new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        };
//        Collections.sort(list, comparator);
//        System.out.println("сортировка: " + list);
//
//        Collections.sort(list, Collections.reverseOrder(comparator));
//        System.out.println("сортировка обратный порядок: " + list);
//
//        System.out.println("частота: " + Collections.frequency(list, "Q"));
//
//        int maxFrequency = 0;                          //задача достать индекс первого элемента, который чаще всего встречается в коллекции
//        int frequency = 0;
//        String frequencyElement = null;
//
//        for (String s : list) {
//            frequency = Collections.frequency(list, s);
//            if (frequency > maxFrequency) {
//                maxFrequency = frequency;
//                frequencyElement = s;
//            }
//        }
//        System.out.println(list.indexOf(frequencyElement));
//
//        Collections.replaceAll(list, "Q", "W");
//        System.out.println("замена элемента по всей коллекции: " + list);

        TestSpeed test = new TestSpeed();
//        test.testAdd(1000*1000);
        test.testGet(1000*100);


    }
}
