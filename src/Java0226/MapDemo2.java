package Java0226;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 遍历Map集合
 */
public class MapDemo2 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        System.out.println(map.put("huang",1));
        System.out.println(map.put("long",2));
        System.out.println(map.put("long1",3));
        System.out.println(map);

        //方式一：keySet()
        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.println(map.get(s));
        }

        /**
         * 方式二：
         * Set<Map.Entry<K,V>> entrySet()
         *           返回此映射所包含的映射关系的 Set 视图。
         */
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        System.out.println(entries);
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
