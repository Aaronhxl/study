package JavaConcurrent.day_0305.demo20;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * 改良上一版程序，由于线程2一直在等待，十分浪费cpu资源
 * 可以利用wait()和 notify()去通知
 * 按照下面解决方法
 *
 */
public class Test03 {

   volatile ArrayList<String> arr = new ArrayList<>();

    public void add(String s){
        arr.add(s);
    }

    public int size(){
        return arr.size();
    }


    public static void main(String[] args) {

        Test03 t = new Test03();
        final Object lock = new Object();
        new Thread(()->{
            synchronized (lock){
                System.out.println(Thread.currentThread().getName()+" start");
                if(t.size() != 5){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+" end");
                lock.notify();
            }

        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            synchronized (lock){
                for (int i = 0; i < 10; i++) {
                    t.add("string "+i);
                    System.out.println("add "+ i);
                    if(t.size() == 5) {
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }


        }).start();
    }
}
