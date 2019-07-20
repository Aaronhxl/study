package JavaConcurrent.day_0305;

public class demo01 {

    private int count = 10;
    private Object o = new Object();

    public void fun(){
        synchronized (o){ //任何线程要执行下面代码，必须拿到o的锁，申请的是堆内存中的锁，而不是o这个引用变量
                            //这种称之为互斥锁，只能被一个线程拿到，其他必须等待
            count--;
            System.out.println(Thread.currentThread().getName()+" count = "+count);
        }
    }
}
