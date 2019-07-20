package JavaConcurrent.day_0423.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueDemo {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
       // System.out.println(blockingQueue.add("d"));

        System.out.println(blockingQueue.element());
        System.out.println(blockingQueue.remove("a"));
        System.out.println(blockingQueue.remove("b"));
        System.out.println(blockingQueue.remove("d"));

        System.out.println(blockingQueue.remove("c"));
        System.out.println(blockingQueue.remove("d"));


        System.out.println("--------");

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.peek());

    }
}
