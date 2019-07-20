package Java0216;

import java.util.Iterator;
import java.util.LinkedList;

public class Test01 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.add("huanglong");
        list.addFirst("huang");
        System.out.println(list);
        list.addLast("long");
        System.out.println(list);
        list.add("wu");
        System.out.println(list);
        list.push("hl");
        System.out.println(list);
        String element = list.pop();
        System.out.println(element);
        System.out.println(list);
        Object[] toArray = list.toArray();
        for (Object o:toArray) {
            String s = o.toString();
            System.out.println(s);
        }
    }
}
