package JavaConcurrent.day_0305;

/**
 * synchronized锁定的是一个对象，而不是一段代码
 */
public class demo02 {

    private int count = 10;

    public void fun(){
        synchronized (this){ //任何线程要执行下面代码，必须拿到this的锁
            count--;
            System.out.println(Thread.currentThread().getName()+" count = "+count);
        }
    }
}
