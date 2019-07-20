package JavaConcurrent.day_0308;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 来一个任务起一个线程，如果有线程空闲，来任务则直接使用该线程，默认情况下，在一个线程空闲60秒，将自动销毁
 * 没有限制，看你系统能支持多少线程
 */
public class T08_CachedPool {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        System.out.println(service);

        for (int i = 0; i < 2 ; i++) {
            service.execute(()->{
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }

        System.out.println(service);
        TimeUnit.SECONDS.sleep(80);
        System.out.println(service);
        service.shutdown();
    }
}
