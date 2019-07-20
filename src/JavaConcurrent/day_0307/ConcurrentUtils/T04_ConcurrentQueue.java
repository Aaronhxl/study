package JavaConcurrent.day_0307.ConcurrentUtils;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * 无界队列,并发队列
 *      ConcurrentLinkedQueue  加锁实现
 *      LinkedBlockingQueue     堵塞实现
 *
 */
public class T04_ConcurrentQueue {

    public static void main(String[] args) {
        Queue<String> strs = new ConcurrentLinkedQueue<>();

        for (int i = 0; i < 10; i++) {
            strs.offer("a"+i);//add会抛异常，offer不会
        }

        System.out.println(strs);
        System.out.println(strs.size());

        System.out.println(strs.poll());//拿出来，并删除
        System.out.println(strs.size());

        System.out.println(strs.peek());//拿出来，不删除
        System.out.println(strs.size());
    }
}
