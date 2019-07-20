package JavaConcurrent.day_0308;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的概念
 *
 * 维护了两个队列，等待任务，已经做完的任务
 */
public class T05_ThreadPool {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 6; i++) {
            service.execute(()->{       //往线程池里面丢任务，这样5个线程做六个任务
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }

        System.out.println(service);
        service.shutdown();//是正常的关闭，等线程池里面的任务都运行结束了，才关闭
        System.out.println(service.isTerminated());//是不是任务都执行完了
        System.out.println(service.isShutdown());//关闭并不代表任务结束了，可能还在跑任务
        System.out.println(service);

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println(service);
    }
}
