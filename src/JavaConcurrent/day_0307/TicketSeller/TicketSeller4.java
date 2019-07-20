package JavaConcurrent.day_0307.TicketSeller;

import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;
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
 * TicketSeller3中，锁的太重量级了，效率不高
 *
 */
public class TicketSeller4 {

    static Queue<String> tickets = new ConcurrentLinkedQueue<>();

    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("票编号："+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (true){
                    String s = tickets.poll();
                    /**
                     * 这里虽然也是分开，但是不会出错，判断在后，并且没有在进行修改
                     */
                    if(s == null) break;
                    else System.out.println(Thread.currentThread().getName()+"销售了--"+s);
                }
            }).start();
        }
    }
}
