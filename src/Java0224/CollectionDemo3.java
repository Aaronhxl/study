package Java0224;

import java.util.HashSet;
import java.util.Set;

/**
 * Set集合中不允许存储相同的数据原理
 *
 *
 * String 类中的hashCode()方法：只与内容有关
 *      public int hashCode() {
 *         int h = hash;
 *         if (h == 0 && value.length > 0) {
 *             char val[] = value;
 *
 *             for (int i = 0; i < value.length; i++) {
 *                 h = 31 * h + val[i];
 *             }
 *             hash = h;
 *         }
 *         return h;
 *     }
 *
 */
public class CollectionDemo3 {
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        String s1 = new String("abc");
        String s2 = new String("abc");

        set.add(s1);
        set.add(s2);
        set.add("重地");
        set.add("通话");
        set.add("abc");

        System.out.println(set);

}
}
