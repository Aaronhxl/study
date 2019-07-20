package JavaConcurrent.day_0422;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch
 */

public class CountDownLatchDemo {

    private static CountDownLatch countDownLatch = new CountDownLatch(6);

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 6 ; i++) {
            int temp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"学生离开");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

        countDownLatch.await();//必须到达0才会往下走

        System.out.println("班长离开");


    }

}
