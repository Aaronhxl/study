package JavaConcurrent.day_0306.demo22;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * 写一个固定容量的同步容器，拥有put和get方法，以及getCount方法
 * 能够支持2个生产者以及10个消费者线程的堵塞调用
 *
 * 使用wait和notifyAll实现
 */

public class MyContainer1<T> {
    final private LinkedList<T> list = new LinkedList<>();
    final private int Max =10;//最多10个元素
    private int count = 0;

    public synchronized void put(T t){
        while (list.size() == Max){ //现象为啥用while而不是if，原因，醒的时候，需要再次检查，怕还会有元素加入
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(t);
        ++count;
        System.out.println(Thread.currentThread().getName()+"生产者："+count);
        this.notifyAll();//通知消费者线程进行消费
    }

    public synchronized T get(){
        T t = null;
        while (list.size() == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = list.removeFirst();
        count--;
        System.out.println(Thread.currentThread().getName()+"消费者："+count);
        this.notifyAll();//通知生产者进行生产
        return t;
    }

    public static void main(String[] args) {
        MyContainer1<String> c = new MyContainer1<>();
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
