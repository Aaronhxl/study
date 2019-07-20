package Java0226;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题意：统计每个字符出现的数次
 */
public class MapPractice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        char[] chars = s.toCharArray();
        Map<String,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if(map.containsKey(""+chars[i]) == true){
                Integer integer = map.get(chars[i]+"");
                integer = integer + 1;
                map.put(""+chars[i],integer);
            }else {
                map.put(""+chars[i],1);
            }
        }

        System.out.println(map);
    }
}
