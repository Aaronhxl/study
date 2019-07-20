package JavaConcurrent.day_0305.demo20;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 改良上一版程序，由于线程2一直在等待，十分浪费cpu资源
 * 可以利用wait()和 notify()去通信过程过于复杂
 *
 * 使用Latch（门插）代替wait和notify来进行通知
 *
 * latch的等待是不需要锁定任何对象的
 * CountDownLatch不涉及锁定，当count等于0时，线程继续运行
 * 当不涉及同步，只是涉及线程通信，这时候应该考虑countdownlatch/cyclicbassier/semaphore
 *
 */
public class Test04 {

   volatile ArrayList<String> arr = new ArrayList<>();

    public void add(String s){
        arr.add(s);
    }

    public int size(){
        return arr.size();
    }


    public static void main(String[] args) {

        Test04 t = new Test04();
        CountDownLatch latch = new CountDownLatch(1);//参数1表示，可以下降一次，到0门就打开了
        new Thread(()->{

                System.out.println(Thread.currentThread().getName()+" start");
                if(t.size() != 5){
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+" end");


        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{

                for (int i = 0; i < 10; i++) {
                    t.add("string "+i);
                    System.out.println("add "+ i);
                    if(t.size() == 5) {
                        latch.countDown();//把门打开，下降一次
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }



        }).start();
    }
}
