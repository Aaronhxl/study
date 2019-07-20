package JavaConcurrent.day_0422;

/**
 * 此案例演示Synchronized的可重入锁功能
 */

class Phone{

    public synchronized void SentMES(){
        System.out.println(Thread.currentThread().getName()+"\t send message");
        SentEmail();
    }

    public synchronized void SentEmail(){
        System.out.println(Thread.currentThread().getName()+"\t send email");
    }
}


public class ReenTrantLockDemo01 {
    public static void main(String[] args) {

        Phone phone = new Phone();

        new Thread(()->{
            phone.SentMES();
        },"t1").start();

        new Thread(()->{
            phone.SentEmail();
        },"t2").start();

    }
}
