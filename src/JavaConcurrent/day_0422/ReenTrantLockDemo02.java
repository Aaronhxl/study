package JavaConcurrent.day_0422;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 该例子验证ReenTrantLock的可重入锁的功能
 */

class Stu implements Runnable{


    @Override
    public void run() {
        get();
    }

    ReentrantLock lock = new ReentrantLock();

    public void get(){
        /**
         * 这里我加了两把锁，同样也是正确的，lock和unlock同时使用一对一保证不会出错
         *      少解锁，编译通过，运行不会出错，但是不会退出
         *      少加锁多解锁，编译通过，运行出错，会出异常
         */
        try{
            lock.lock();
            //lock.lock();
            System.out.println(Thread.currentThread().getName()+"\t get方法");
            set();
        }finally {
            lock.unlock();
            lock.unlock();
        }
    }

    public void set(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"\t set方法");
        }finally {
            lock.unlock();
        }
    }
}

public class ReenTrantLockDemo02 {

    public static void main(String[] args) {
        Stu stu = new Stu();
        new Thread(stu).start();

        new Thread(stu).start();
    }
}
