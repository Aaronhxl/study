package Java0222.ThreadPool;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池的测试类
 * 线程池会一直开启，使用完了会自动归还线程池，可以使用shutdown方法关闭线程池
 */
public class Test {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        Runnable task = new MyThread();

        es.submit(task);
        es.submit(task);
        es.submit(task);

        es.shutdown(); // 关闭线程池
    }
}
