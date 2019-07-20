package JavaConcurrent.day_0423.Produtor_Consumer;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Condition的精准唤醒
 */
class Common{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void Print5(){
        lock.lock();
        try {
            while (number != 1){
                c1.await();
            }
            for (int i = 0; i < 5 ; i++) {
                System.out.println(Thread.currentThread().getName()+"   "+i);
            }
            number =  2;
            c2.signal();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void Print10(){
        lock.lock();
        try {
            while (number != 2){
                c2.await();
            }
            for (int i = 0; i < 10 ; i++) {
                System.out.println(Thread.currentThread().getName()+"   "+i);
            }
            number =  3;
            c3.signal();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void Print15(){
        lock.lock();
        try {
            while (number != 3){
                c3.await();
            }
            for (int i = 0; i < 15 ; i++) {
                System.out.println(Thread.currentThread().getName()+"   "+i);
            }
            number =  1;
            c1.signal();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

}

public class ConditionDemo {

    public static void main(String[] args) {

        Common common = new Common();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                common.Print5();
            }

        }).start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                common.Print10();
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                common.Print15();
            }
        }).start();

    }
}
