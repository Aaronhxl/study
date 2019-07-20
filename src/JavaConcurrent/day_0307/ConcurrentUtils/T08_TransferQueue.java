package JavaConcurrent.day_0307.ConcurrentUtils;

import java.util.concurrent.LinkedTransferQueue;

/**
 * LinkedTransferQueue队列中，生产者一生产出来的话，如果有消费者在等待，就直接给消费者，而不用存入等待队列
 * 而要是找不到消费者则会阻塞
 */

public class T08_TransferQueue {

    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();
        new Thread(()->{
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        strs.transfer("aaa"); //只有它会阻塞

        /*new Thread(()->{
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();*/
    }
}
