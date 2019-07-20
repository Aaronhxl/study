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
 *
 *   可以使用lock.lockInterruptibly()进行打断
 *
 *   ReentrantLock还可以指定公平锁
 *   例子：一个等了时间长的比时间短的更容易被执行，synchronized是非公平的（大家一样的竞争）
 *    private static ReentrantLock lock = new ReentrantLock(true);//参数为true表示公平锁，请对比输出结果
 */

public class ReentrantLock5 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+"获得锁"+i);
            }finally {
                lock.unlock();
            }
        }
    }

    private static ReentrantLock lock = new ReentrantLock(true);//参数为true表示公平锁，请对比输出结果

    public static void main(String[] args) {
        ReentrantLock5  r1 = new ReentrantLock5();
        Thread t1 = new ReentrantLock5();
        Thread t2 = new ReentrantLock5();
        t1.start();
        t2.start();
    }
}
