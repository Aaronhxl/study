package JavaConcurrent.day_0420.ContainerNotSafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 此例为验证集合容器线程不安全:ArrayList
 *
 *  在多线程的环境下，
 *      1.ArrayList将会出现java.util.ConcurrentModificationException异常
 *      2.解决
 *          vector：vector为线程安全类，底层加了synchronized，用锁机制保证
 *          Collections.synchronizedList：构建一个线程安全的集合
 *          copyOnWriteArrayList
 *
 */
public class ContainerNotSafeDemo01 {

    public static void main(String[] args) {

        //List<String> arr = new ArrayList<>();
        //List<String> arr = new Vector<>();//方式一：使用vector，可保证线程安全
        //List<String> arr = Collections.synchronizedList(new ArrayList<>());//构建一个线程安全的集合
        List<String> arr = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {

            new Thread(()->{
                arr.add(UUID.randomUUID().toString().substring(0,8));//以下两条操作并不是原子性，故可能被打断，导致执行数量不是从1开始
                System.out.println(arr);
            }).start();

        }

        while (Thread.activeCount()>2){
            Thread.yield();
        }

        System.out.println(arr.size());



    }
}
