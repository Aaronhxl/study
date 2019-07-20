package Java0216;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//iter为foreach的快捷键
//string重写了object类中的hashcode方法
//有一个特殊情况，重地和通话，值不一样，但是hashcode却是一样的
public class Test02 {
    public static void main(String[] args) {
        Set<String> list = new HashSet<>();
        list.add("hl");
        list.add("huanglong");
        list.add("maybe");
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            String s = it.next();
            System.out.println(s
            );
        }
        System.out.println("----------------");
        for (String s : list) {
            System.out.println(s);
        }

        int list_hashcode = list.hashCode();
        System.out.println(list_hashcode);

        String s = new String("abc");
        String s1 = new String("abc");
        System.out.println(s.hashCode());
        System.out.println(s1.hashCode());

        System.out.println("重地".hashCode());
        System.out.println("通话".hashCode());

        System.out.println("huanglong".hashCode());
        String s2 = "huanglong";
        String s3 = new String("huanglong");

        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
    }
}
