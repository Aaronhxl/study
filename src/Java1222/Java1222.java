package Java1222;

import java.util.Arrays;

public class Java1222 {
    public static void main(String[] args) {
//        interface_2 interface_2 = new imple_2();
//        interface_2.printf();
        String[] s = {"123","246","894342347","4637647"};
        Arrays.sort(s,new LengthComparator());
        for (String s1: s) {
            System.out.println(s1);
        }
    }
}

