package JavaConcurrent.day_0307.TicketSeller;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * 有N张火车票，每张票都有一个编号
 * 同时有10个窗口对外售票
 * 请写一个模拟程序
 *
 * 分析下列程序可能出现的问题
 *
 * TicketSeller1使用的ArrayList容器不是同步的，里面的各种各样的方法也不是同步的
 * TicketSeller2使用的Vector容器是同步的，里面的各种方法也是同步的
 *
 */
public class TicketSeller3 {

    static Vector<String> tickets = new Vector<>();

    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("票编号："+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                synchronized (tickets){
                    if (tickets.size()>0){ //这里其实依旧有问题，已经将判断和操作分离了，下面可以加一些延时来放大错误

                        try {
                            TimeUnit.MILLISECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                            System.out.println(Thread.currentThread().getName()+"销售了--"+tickets.remove(0));
                    }
                }
            }).start();
        }
    }
}
