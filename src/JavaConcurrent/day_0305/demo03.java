package JavaConcurrent.day_0305;

/**
 * synchronized锁定的是一个对象，而不是一段代码
 * 等同于demo2中的代码，锁对象为this
 */
public class demo03 {

    private int count = 10;

    public synchronized void fun(){
            count--;
            System.out.println(Thread.currentThread().getName()+" count = "+count);
    }
}
