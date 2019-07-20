package JavaConcurrent.day_0308;

import java.util.concurrent.*;

/**
 * Future ； 指一个线程你丢进线程池之后，它执行完之后，在未来的某个时间返回给你的返回值，类型为Future
 */
public class T06_Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> task = new FutureTask<>(()->{ //未来任务，FutureTask可以包装callable的接口对象
            TimeUnit.MILLISECONDS.sleep(500); //使用callable接口，Integer为其返回值类型
            return 1000;
        });

        new Thread(task).start();//FutureTask实现了Runnable接口

        System.out.println(task.get());//阻塞,一直等这个任务结束，拿到返回值

        ExecutorService service = Executors.newFixedThreadPool(5);

        Future<Integer> f = service.submit(()->{
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });

      //  System.out.println(f.get());
        System.out.println(f.isDone());
        System.out.println(f.get());
        System.out.println(f.isDone());

    }
}
