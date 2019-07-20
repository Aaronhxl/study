package JavaConcurrent.day_0306.demo22;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 写一个固定容量的同步容器，拥有put和get方法，以及getCount方法
 * 能够支持2个生产者以及10个消费者线程的堵塞调用
 *
 * 使用wait和notifyAll实现
 *
 * 使用Lock和Condition来实现
 * 对比两种方式，condition的方式可以更加精确的指定哪些线程被唤醒
 *
 * 一个condition对象的signal（signalAll）方法和该对象的await方法是一一对应的，
 * 也就是一个condition对象的signal（signalAll）方法不能唤醒其他condition对象的await方法
 * ReentrantLock类可以唤醒指定条件的线程，而object的唤醒是随机的
 */

public class MyContainer2<T> {
    final private LinkedList<T> list = new LinkedList<>();
    final private int Max =10;//最多10个元素
    private int count = 0;

    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void put(T t){
        try{
            lock.lock();
            while (list.size() == Max){ //现象为啥用while而不是if，原因，醒的时候，需要再次检查，怕还会有元素加入
                producer.await();
            }
            list.add(t);
            ++count;
            System.out.println(Thread.currentThread().getName()+"生产者："+count);
            consumer.signalAll();//通知消费者线程进行消费
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public  T get(){
        T t = null;
        try{
            lock.lock();
            while (list.size() == 0){
                consumer.await();
            }
            t = list.removeFirst();
            count--;
            System.out.println(Thread.currentThread().getName()+"消费者："+count);
            producer.signalAll();//通知生产者进行生产
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        MyContainer2<String> c = new MyContainer2<>();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 5; j++) {
                    System.out.println(c.get());
                }
            }).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i <2 ; i++) {
            new Thread(()->{
                for (int j = 0; j < 25; j++) {
                    c.put(Thread.currentThread().getName()+" "+j);
                }
            },"p"+i).start();
        }
    }

}
