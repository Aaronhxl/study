package JavaConcurrent.day_0422;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁,
 *      写时，保证原子操作
 *      读时，提高并发量
 */

class demo{

    private volatile static Map<String,String> map = new HashMap<>();
    private static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public void put(String key,String value){

        rwl.writeLock().lock();
        System.out.println(Thread.currentThread().getName()+"正在写入");
        map.put(key,value);
        System.out.println(Thread.currentThread().getName()+"写入完成");
        rwl.writeLock().unlock();
    }

    public void get(String key){

        rwl.readLock().lock();
        System.out.println(Thread.currentThread().getName()+"正在读取");
        map.get(key);
        System.out.println(Thread.currentThread().getName()+"读取完成");
        rwl.readLock().unlock();
    }
}


public class ReentrantReadWirteLockDemo {

    public static void main(String[] args) {
        
        demo demo = new demo();

        for (int i = 0; i <5 ; i++) {
            final int temp = i;
            new Thread(()->{
                demo.put(temp+"",temp+"");
            }).start();
        }

        for (int i = 0; i <5 ; i++) {
            final int temp = i;
            new Thread(()->{
                demo.get(temp+"");
            }).start();
        }

    }
}
