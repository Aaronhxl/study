package JavaConcurrent.day_0420;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 基于CAS的安全操作，比较并交换     期待值、真实值、更新值
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        atomicInteger.compareAndSet(5,6);

        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.getAndIncrement());//返回的是之前的值
        System.out.println(atomicInteger.get());
    }
}
