package JavaConcurrent.day_0306.demo23;

import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal线程局部变量
 */

public class ThreadLocal1 {

    volatile static Person p = new Person();//不写volatile有可能有问题

    public static void main(String[] args) {

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(p.name);
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.name = "lisi";
        }).start();
    }
}

class Person{
    String name = "zhangsan";
}