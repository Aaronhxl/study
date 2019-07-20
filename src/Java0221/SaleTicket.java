package Java0221;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicket implements Runnable{

    //设置总票数
    private static int amount = 100;
    //利用同步代码块保证线程安全
    Object obj = new Object();
    //利用锁机制
    Lock lock = new ReentrantLock();

    /**
     * 卖票线程执行体
     */
    @Override
    public void run() {
        while (true){
            //方式一：同步代码块保证线程安全
//            synchronized (obj){
//                if(amount<=0) return;
//                else {
//                    System.out.println("这是由"+Thread.currentThread().getName()+"卖出的是第"+amount+"张票");
//                    amount--;
//                }
//            }
            //方式二：同步方法
            //saleTicket();

            //方式三：Lock锁机制
            lock.lock();
           try {
               if(amount<=0) return;
               else {
                   System.out.println("这是由"+Thread.currentThread().getName()+"卖出的是第"+amount+"张票");
                   amount--;
               }
           }catch (Exception e){
               System.out.println(e);
           }finally {
               lock.unlock();
           }

        }

    }

    //方式二：同步方法保证线程安全
    public synchronized void saleTicket(){
        if(amount<=0) return;
        else {
            System.out.println("这是由"+Thread.currentThread().getName()+"卖出的是第"+amount+"张票");
            amount--;
        }
    }
}
