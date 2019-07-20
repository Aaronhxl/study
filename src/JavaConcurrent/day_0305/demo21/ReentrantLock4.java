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
 *  使用reentrantlock可以进行”尝试锁定“trylock，这样无法锁定，或者在指定时间内无法锁定，线程可以决定是否继续等待
 *  可以使用lock.lockInterruptibly()进行打断
 *
 */

public class ReentrantLock4 {


    Lock lock = new ReentrantLock();

     void m1(){

         try{
             lock.lock();
             for (int i = 0; i < 10; i++) {
                 TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                 System.out.println("m1 end");
             }
         }catch (InterruptedException e){
             e.printStackTrace();
         }finally {
             lock.unlock();
         }
    }

    /**
     * 使用trylock进行尝试锁定，不管锁定与否，方法都将继续进行
     * 可以根据trylock的返回值来判定是否锁定
     * 有可以指定trylock的时间，由于trylock(time)抛出异常，所以要注意unlock的处理，必须放到finally中
     */
     void m2(){

         try{
             lock.lockInterruptibly();
             System.out.println("m2 ...");
         }catch (InterruptedException e){
             e.printStackTrace();
         }finally {
             lock.unlock();
         }
    }

    public static void main(String[] args) {

        ReentrantLock4 r1 = new ReentrantLock4();
        new Thread(r1::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread = new Thread(r1::m2);
        thread.start();
        thread.interrupt();
    }
}
