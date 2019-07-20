package Java0222.ThreadPool;

public class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"正在执行任务");
    }
}
