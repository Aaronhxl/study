package JavaConcurrent.day_0307.ConcurrentUtils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * 一种特殊的TransferQueue,这是一种时时的，容量为0，来了你必须处理
 */
public class T09_SynchronusQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> strs = new SynchronousQueue<>();
        new Thread(()->{
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        strs.put("aaa");//阻塞等待消费者消费
       // strs.add("aaa");//出错
        System.out.println(strs.size());
    }
}
