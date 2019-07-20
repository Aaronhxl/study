package JavaConcurrent.day_0305.demo20;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * 改良上一版程序，由于线程2一直在等待，十分浪费cpu资源
 * 可以利用wait()和 notify()去通知
 *
 * wait()会释放锁，而notify（）不会释放锁
 * 需要注意的是：运用这种方法，必须要保证t2先执行，也就是先监听才可以
 *
 * 以下代码并不能完成任务，原因：notify()并不释放锁，就算叫醒了线程1，也没有锁对象，并不能运行
 *
 * sleep()不释放锁
 *
 */
public class Test02 {

   volatile ArrayList<String> arr = new ArrayList<>();

    public void add(String s){
        arr.add(s);
    }

    public int size(){
        return arr.size();
    }


    public static void main(String[] args) {

        Test02 t = new Test02();
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
