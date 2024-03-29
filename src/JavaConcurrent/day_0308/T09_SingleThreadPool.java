package JavaConcurrent.day_0308;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池里就一个线程，保证线程一定按前后顺序执行
 */
public class T09_SingleThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            final int j = i;
            service.execute(()->{
                System.out.println(j+" "+Thread.currentThread().getName());
            });
        }
        service.shutdown();
    }
}
