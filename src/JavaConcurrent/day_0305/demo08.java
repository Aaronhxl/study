package JavaConcurrent.day_0305;

import java.util.concurrent.TimeUnit;

/**
 * 对业务写方法加锁
 * 对业务读方法不加锁
 * 容易产生脏读问题（dirtyRead）
 *
 * 需要对读也加锁
 */
public class demo08 {
    public static void main(String[] args) {
        Account a = new Account();
        new Thread(()->a.set("zhangsan",100)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a.getBalance("zhangsan"));
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a.getBalance("zhangsan"));
    }

}

class Account{
    String name;
    double balance;

    public synchronized void set(String name,double balance){
        this.name = name;
        try {    //放大的错误，比如网络延迟
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public /*synchronized*/double getBalance(String name){
        return this.balance;
    }

}
