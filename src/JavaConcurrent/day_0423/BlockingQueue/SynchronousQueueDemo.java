package JavaConcurrent.day_0423.BlockingQueue;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {
    public static void main(String[] args) {

        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();


        new Thread(()->{
            try {

                System.out.println("put a");
                synchronousQueue.put("a");
                System.out.println("put b");
                synchronousQueue.put("b");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
                synchronousQueue.take();
                System.out.println("take a");
                synchronousQueue.take();
                System.out.println("take b");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
    }
}
