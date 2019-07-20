package JavaConcurrent.day_0307.ConcurrentUtils;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;


/**
 * 有界队列
 *
 * 容器满了，用不同的方法，不同的结果
 */
public class T06_ArrayBolckQueue {

    static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10);

    static Random r = new Random();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            strs.put("a"+i);
        }

            strs.put("aaa");//满了会阻塞
//        strs.add("aaa");//会抛异常
//        strs.offer("aaa");//不会抛异常
//        strs.offer("aaa", 1,TimeUnit.SECONDS);//按时间阻塞
        System.out.println(strs);
    }
}
