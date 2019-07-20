package JavaConcurrent.day_0305.demo21;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 *  reentrantlock用于代替synchronized
 *  本例中由于m1锁定this，只有m1执行完毕的时候，m2才能执行
 *  这里是复习synchronized最原始的语义
 *
 *  使用reentrantlock可以完成相同的功能
 *  需要注意的是，必须要手动释放锁,手动上锁
 *  使用syn锁定的话，如果遇到异常，jvm会自动释放锁，但是lock必须手动释放锁，因此经常在finally中进行锁的释放
 *
 */

public class ReentrantLock2 {


    Lock lock = new ReentrantLock();

     void m1(){

         try{
             lock.lock();
             for (int i = 0; i < 10; i++) {
                 TimeUnit.SECONDS.sleep(1);
                 System.out.println(i);
             }
         }catch (InterruptedException e){
             e.printStackTrace();
         }finally {
             lock.unlock();
         }
    }

     void m2(){

         lock.lock();
         System.out.println("m2 ...");
         lock.unlock();
    }

    public static void main(String[] args) {

        ReentrantLock2 r1 = new ReentrantLock2();
        new Thread(r1::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r1::m2).start();

    }
}
