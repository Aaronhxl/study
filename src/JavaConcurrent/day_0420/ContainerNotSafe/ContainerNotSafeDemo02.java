package JavaConcurrent.day_0420.ContainerNotSafe;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 此例，验证Set集合的线程不安全
 *      同样可能会出现java.util.ConcurrentModificationException，多线程并发问题
 *
 *      解决方式：
 *          1.Collections.synchronizedSet(new HashSet<>())
 *          2.new CopyOnWriteArraySet<>()
 *
 */
public class ContainerNotSafeDemo02 {

    public static void main(String[] args) {

        //Set<String> set = new HashSet<>();

       // Set<String> set = Collections.synchronizedSet(new HashSet<>());

        Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            }).start();
        }

    }
}
