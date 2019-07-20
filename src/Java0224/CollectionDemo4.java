package Java0224;

import java.util.HashSet;
import java.util.Set;

/**
 * 利用Set集合存储自定义元素
 * object类中的hashCode方法：
 *  该对象的内部地址转换成一个整数来实现的,为逻辑地址转换
 *
 *
 *  == 号的比较原则
 * 两侧为基本类型时，比较的是值的大小是否相等。
 *
 * 两侧为引用类型时，比较的是地址值是否相同。
 */
public class CollectionDemo4 {

    public static void main(String[] args) {
        Person p1 = new Person("黄龙",23);
        Person p2 = new Person("黄龙",23);
        Person p3 = new Person("黄小龙",23);

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());

        System.out.println(p1==p2);
        System.out.println(p1.equals(p2));

        Set<Person> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        set.add(p3);

        System.out.println(set);
    }
}
