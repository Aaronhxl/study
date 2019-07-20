package Java0224;

import java.util.*;

/**
 * Collection集合的工具类Collections的使用
 *      1.addAll(Collection<? super T> c, T... elements) 将所有指定元素添加到指定 collection 中
 *      2.static void shuffle(List<?> list) 使用默认随机源对指定列表进行置换
 *      3.sort(List<T> list) 根据元素的自然顺序 对指定列表按升序进行排序
 *      4.sort(List<T> list, Comparator<? super T> c)根据指定比较器产生的顺序对指定列表进行排序
 *      5.reverse(List<?> list)反转指定列表中元素的顺序。
 *      6.max(Collection<? extends T> coll)根据元素的自然顺序，返回给定 collection 的最大元素
 *      7.max(Collection<? extends T> coll, Comparator<? super T> comp)根据指定比较器产生的顺序，返回给定 collection 的最大元素
 *      8.min(Collection<? extends T> coll)根据元素的自然顺序 返回给定 collection 的最小元素
 *      9.min(Collection<? extends T> coll, Comparator<? super T> comp)根据指定比较器产生的顺序，返回给定 collection 的最小元素
 *
 *
 * 注意：
 *      1.对于已经实现了Comparator接口的类可以考虑第一种sort函数，默认为正序，升序排序
 *      2.对于按照逆序排序的需求，可以用第二种，用匿名内部类对象，也无需实现Comparator接口
 *      3.比较器
 *              如果返回值是0，表示o1和o1相等
 *              如果返回值是负数，表示o1比o2小
 *              如果返回值是整数，表示o1比o2大
 *              升序就是1减2
 *              降序就是2减1
 *
 * 通配符：
 *      Content<? extends Animal> content，这个content容器里面可以放任何Animal包括其子类。
 *      Content<? super Animal> content 表示的是Animal 以及Animal基类的容器
 */
public class CollectionsDemo1 {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();//hashSet集合是无序的

        set.add("huang");
        System.out.println(set);

        String[] ss = {"long","haung","zhe","jiang"};
        Collections.addAll(set,ss);

        System.out.println(set);

        String max = Collections.max(set, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(max);

        String min = Collections.min(set, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(min);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        Integer[] ii = {2,8,-9,37,63};
        Collections.addAll(list,ii);
        System.out.println("排序前");
        System.out.println(list);
        Collections.sort(list);
        System.out.println("默认排序后");
        System.out.println(list);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2>o1?1:-1;
            }
        });
        System.out.println("自定义排序后");
        System.out.println(list);

    }
}
