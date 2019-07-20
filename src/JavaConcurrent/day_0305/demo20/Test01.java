package JavaConcurrent.day_0305.demo20;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * 实现一个容器，一个线程add，一个线程返回size
 * 问下面代码是否有问题
 *
 * 有问题：需要保证arr的线程间的可见性 加上volatile关键字
 */
public class Test01 {

    /*volatile*/  ArrayList<String> arr = new ArrayList<>();

    public void add(String s){
        arr.add(s);
    }

    public int size(){
        return arr.size();
    }


    public static void main(String[] args) {

        Test01 t = new Test01();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                t.add("string "+i);
                System.out.println("add "+ i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }).start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" start");
            while (true){
                if(t.size() == 5){
                    break;
                }
            }
            System.out.println(Thread.currentThread().getName()+" end");
        }).start();

    }
}
