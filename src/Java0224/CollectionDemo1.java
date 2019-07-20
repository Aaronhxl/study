package Java0224;

import java.util.*;

/**
 * 集合框架的学习
 */
public class CollectionDemo1 {
    public static void main(String[] args) {
        Collection<Integer> arr = new ArrayList<>();
        Collection<String> list = new LinkedList<>();

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(2);
        System.out.println(arr);

        arr.remove(1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.contains(3);

        int size = arr.size();

        Object[] objects = arr.toArray();

        //Iterator
    }
}
