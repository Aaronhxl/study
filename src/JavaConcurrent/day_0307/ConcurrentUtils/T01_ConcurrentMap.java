package JavaConcurrent.day_0307.ConcurrentUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

/**
 * 参考文章：http://blog.csdn.net/sunxianghuang/article/details/52221913
 *          http://www.educity.cn/java/498061.html
 */

/**
 * ConcurrentHashMap与 Hashtable的区别
 *
 * Hashtable在插入数据的时候是将整个对象锁定，这个map对象锁定
 *
 * ConcurrentHashMap在插入数据的时候是将对象分成16份，而只锁定其中一份，这样只要它没有锁定的其他份，就可以并发插入了
 */

public class T01_ConcurrentMap {

    public static void main(String[] args) {
       // Map<String,String> map = new ConcurrentHashMap<>(); //并发高的情况，不需要排序 381
       // Map<String,String> map = new ConcurrentSkipListMap<>();//546，高并发排序

        //Map<String,String> map = new Hashtable<>(); //默认带锁 506
        Map<String,String> map = new HashMap<>(); //Collectionns.synchronizedXXX()也是带锁的 277

        Random r = new Random();
        Thread[] ths = new Thread[100];
        CountDownLatch latch = new CountDownLatch(ths.length);
        long start = System.currentTimeMillis();
        for (int i = 0; i < ths.length; i++) {
            ths[i] = new Thread(()->{
                for (int j = 0; j <10000 ; j++) {
                    map.put("a"+r.nextInt(100000),"a"+r.nextInt(100000));
                }
                latch.countDown();
            });
        }

        Arrays.asList(ths).forEach(o->o.start());

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
