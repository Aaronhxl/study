package JavaConcurrent.day_0305;

/**
 * 一个同步方法可以调用另外一个同步方法，一个线程已经拥有某个对象的锁，再次申请的时候依旧会得到该对象的锁
 * 也就是是synchronized获得的锁是可重入的，这是在一个线程里面--》重入锁
 * 锁可重入：同一个线程，多次调用同步代码，锁定同一个锁对象，可重入
 */

import java.util.concurrent.TimeUnit;

public class demo09 {
}

class T{
    synchronized void m1(){
        System.out.println("m1 start...");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
    }

    synchronized void m2(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2");
    }
}