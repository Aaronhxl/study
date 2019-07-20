package JavaConcurrent.day_0305;

import java.util.concurrent.TimeUnit;

/**
 * volatile关键字，使一个变量在多个线程间可见，默认线程不可见
 * A B线程都用到一个变量，Java默认是A线程中保留一份copy，这样如果B线程修改了该变量，则A线程未必知道
 * 使用volatile关键字，会让所有线程都会读到该变量的修改值
 * (就是通知其他线程，你们的缓冲区的数据已经过期，需要重新到主内存来读)
 *
 * 通知cpu操作系统层，在cpu计算过程中，都要检查内存中数据的有效性，保证最新的内存数据被使用
 */
public class demo12 {

   /*volatile*/ boolean running = true; //对比一下有无volatile的情况下，整个程序运行结果的区别

    void m(){
        System.out.println("m start");
        while (running){

            //在while中做一点cpu操作，是可以结束的，因为cpu在做操作的时候，总有一些时间是空出来，
            //去读主内存的东西，所以这样做可能会也可能不会
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        demo12 t = new demo12();
        new Thread(t::m,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.running = false;
    }
}
