package Java0226;

import java.util.*;

/**
 * Map集合的特点：
 *      1.Map集合是一个双列集合，一个集合包含两个值（一个key,一个value）
 *      2.Map集合中的元素，key和value的数据类型可以相同，也可以不同
 *      3.Map集合中的元素，key是不允许重复的，value是可以重复的
 *      4.Map集合中的元素，key和value是一一对应的
 */
public class MapDemo1 {
    public static void main(String[] args) {
       // show01();
        show02();
        show03();
        show04();
        show05();
    }

    /**
     * Collection<V> values()
     *           返回此映射所包含的值的 Collection 视图。
     */
    private static void show05() {
        Map<String,Integer> map = new HashMap<>();
        System.out.println(map.put("huang",1));
        System.out.println(map.put("long",2));
        System.out.println(map.put("long1",3));
        System.out.println(map);

        Collection<Integer> values = map.values();
        System.out.println(values);
        for (Integer value : values) {
            System.out.println(value);
        }
    }

    /**
     * boolean containsKey(Object key)
     *           如果此映射包含对于指定键的映射关系，则返回 true。
     *  boolean containsValue(Object value)
     *           如果此映射将一个或多个键映射到指定值，则返回 true。
     */

    private static void show04() {
        Map<String,Integer> map = new HashMap<>();
        System.out.println(map.put("huang",1));
        System.out.println(map.put("long",2));
        System.out.println(map.put("long1",3));
        System.out.println(map);
        System.out.println(map.containsKey("huang"));
        System.out.println(map.containsKey("123"));
        System.out.println("---------");
        System.out.println(map.containsValue(1));
        System.out.println(map.containsValue(4));
    }

    /**
     *  V get(Object key)返回指定键所映射的值；如果对于该键来说，此映射不包含任何映射关系，则返回 null。
     *  注意：
     *      1.如果不存在，返回null
     *      2.存在，返回值
     */
    private static void show03() {
        Map<String,Integer> map = new HashMap<>();
        System.out.println(map.put("huang",1));
        System.out.println(map.put("long",2));
        System.out.println(map.put("long1",3));
        System.out.println(map);


        System.out.println(map.get("huang"));
        System.out.println(map.get("123"));


    }

    /**
     * V remove(Object key)从此映射中移除指定键的映射关系（如果存在）。
     * 注意：
     *      1.如果存在，返回被删除的值
     *      2.如果不存在，返回null
     */
    private static void show02() {

        Map<String,Integer> map = new HashMap<>();
        System.out.println(map.put("huang",1));
        System.out.println(map.put("long",2));
        System.out.println(map.put("long1",3));
        System.out.println(map);

        System.out.println(map.remove("huang"));
        System.out.println(map);
        System.out.println(map.remove("long"));
        System.out.println(map.remove("123"));
        System.out.println(map);


    }

    /**
     *  V put(K key, V value) 在此映射中关联指定值与指定键。
     *
     *  注意：
     *      1.存储中，要是key不重复，返回的是null
     *      2.要是key重复，返回被替换的旧值
     */
    private static void show01() {
        Map<String,Integer> map = new HashMap<>();
        System.out.println(map.put("huang",1));
        System.out.println(map.put("long",2));
        System.out.println(map.put("long",3));

        System.out.println(map);
        System.out.println("-------");
        //遍历
        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.println(map.get(s));
        }
    }
}

