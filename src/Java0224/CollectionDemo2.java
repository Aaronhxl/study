package Java0224;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * HsahSet集合的使用
 *
 * HashSet()
 *           构造一个新的空 set，其底层 HashMap 实例的默认初始容量是 16，加载因子是 0.75。
 * HashSet(Collection<? extends E> c)
 *           构造一个包含指定 collection 中的元素的新 set。
 * HashSet(int initialCapacity)
 *           构造一个新的空 set，其底层 HashMap 实例具有指定的初始容量和默认的加载因子（0.75）。
 * HashSet(int initialCapacity, float loadFactor)
 *           构造一个新的空 set，其底层 HashMap 实例具有指定的初始容量和指定的加载因子。
 */
public class CollectionDemo2 {

    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("huang");
        hashSet.add("long");
        hashSet.add("zhe");
        hashSet.add("huang");
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for (String s : hashSet) {
            System.out.println(s);
        }
    }
}
