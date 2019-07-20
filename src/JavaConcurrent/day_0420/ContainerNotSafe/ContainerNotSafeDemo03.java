package JavaConcurrent.day_0420.ContainerNotSafe;



import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 此案例验证Map集合的线程不安全
 *
 *
 *      同样可能发生java.util.ConcurrentModificationException
 *       解决：
 *          1.new Hashtable()
 *          2.Collections.synchronizedMap(new HashMap<>());
 *          3.new ConcurrentHashMap<>();
 *
 */
public class ContainerNotSafeDemo03 {

    public static void main(String[] args) {
        //Map<String,String> map = new HashMap<>();

        //Map<String,String> map =new Hashtable<>();
        //Map<String,String> map =Collections.synchronizedMap(new HashMap<>());
        Map<String,String> map =new ConcurrentHashMap<>();

        for (int i = 0; i < 10 ; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            }).start();
        }
    }
}
