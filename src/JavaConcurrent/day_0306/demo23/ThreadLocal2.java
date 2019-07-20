package JavaConcurrent.day_0306.demo23;

import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal线程局部变量
 *
 * 线程间的共有变量相互不影响
 */

public class ThreadLocal2 {

    //volatile static Person p = new Person();//不写volatile有可能有问题
    static ThreadLocal<Person> tl = new ThreadLocal<>();

    public static void main(String[] args) {

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(tl.get());
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           tl.set(new Person());//别的线程看不着
        }).start();
    }

    static class Person{
        String name = "zhangsan";
    }
}
