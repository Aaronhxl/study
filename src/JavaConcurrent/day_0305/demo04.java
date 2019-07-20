package JavaConcurrent.day_0305;

/**
 * synchronized锁定的是一个对象，而不是一段代码
 */
public class demo04 {

    private static int count = 10;

    public static synchronized void fun1(){ //此时这里的锁对象为，demo4.class
            count--;
            System.out.println(Thread.currentThread().getName()+" count = "+count);
    }

    public static  void fun2(){ //等同于上述代码，这里不可以写this，由于static的时候并没有this对象，只有其类对象
        synchronized (demo04.class){
            count--;
            System.out.println(Thread.currentThread().getName()+" count = "+count);
        }
    }
}
