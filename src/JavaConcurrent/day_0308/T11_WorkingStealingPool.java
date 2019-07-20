package JavaConcurrent.day_0308;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 任务窃取线程池，本质上 还是ForkJoinPool
 * 偷任务执行，线程池里面维持了自己的一个任务队列，当自己的任务队列中的任务结束后，可以到其他还有任务的线程的队列中偷取任务执行
 */
public class T11_WorkingStealingPool {
    public static void main(String[] args) throws IOException {
        ExecutorService service = Executors.newWorkStealingPool();//根据cpu的核数，起多少线程
        System.out.println(Runtime.getRuntime().availableProcessors());

        service.execute(new R(1000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));

        //由于生产的是精灵线程（守护线程、后台线程），主线程不阻塞的话啊，看不到输出
        //在后台不断运行的，只要有任务，就去拿
        System.in.read();
        service.shutdown();
    }

    static class R implements Runnable{

        int time;

        public R(int time) {
            this.time = time;
        }

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
