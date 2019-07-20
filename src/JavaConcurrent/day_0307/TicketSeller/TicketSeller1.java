package JavaConcurrent.day_0307.TicketSeller;

import java.util.ArrayList;
import java.util.List;

/**
 * 有N张火车票，每张票都有一个编号
 * 同时有10个窗口对外售票
 * 请写一个模拟程序
 *
 * 分析下列程序可能出现的问题
 *
 * 这里使用的ArrayList容器不是同步的，里面的各种各样的方法也不是同步的
 */
public class TicketSeller1 {

    static List<String> tickets = new ArrayList<>();

    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("票编号："+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                //synchronized (TicketSeller1.class){
                    while (tickets.size()>0){
                        System.out.println(Thread.currentThread().getName()+"销售了--"+tickets.remove(0));
                    }
                //}
            }).start();
        }
    }
}
