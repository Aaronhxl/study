package JavaConcurrent.day_0422;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 模拟6辆车子枪3个停车位
 * Semaphore
 */

public class SemaphoreDemo {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i <6 ; i++) {

            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("3秒钟之后离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }).start();
        }


    }
}
