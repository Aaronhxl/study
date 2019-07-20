package JavaConcurrent.day_0305;

/**
 * 模拟线程死锁问题的代码
 */

import java.util.concurrent.TimeUnit;

public class DeadLocks {
    static Object o1 = new Object();
    static Object o2 = new Object();

    public void fun1(){
        synchronized (o1){
            System.out.println("fun1 start");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fun2();
            System.out.println("fun1 end");
        }
    }

    public void fun2(){
        synchronized (o2){
            System.out.println("fun2 start");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fun1();
            System.out.println("fun2 end");
        }
    }


    public static void main(String[] args) {

        DeadLocks d = new DeadLocks();

        new Thread(()->d.fun1()).start();
        new Thread(()->d.fun2()).start();
    }
}

