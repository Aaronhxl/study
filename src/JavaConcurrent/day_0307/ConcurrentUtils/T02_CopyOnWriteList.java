package JavaConcurrent.day_0307.ConcurrentUtils;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 写时负值容器 copy on write
 * 多线程环境下，写时效率低，读时效率高
 *
 * 写的时候是把元素从一个容器复制到另外一个容器中
 * 适合写少读多的环境
 *
 * 事件监听器用的多
 */
public class T02_CopyOnWriteList {
    public static void main(String[] args) {

       // List<String> lists = new ArrayList<>();//会出现并发问题
       // List<String> lists = new Vector<>();
        List<String> lists = new CopyOnWriteArrayList<>();
        Random r = new Random();
        Thread[] ths = new Thread[100];

        for (int i = 0; i <ths.length ; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        lists.add("a"+r.nextInt(10000));
                    }
                }
            };
            ths[i] = new Thread(task);
        }

        runAndComputer(ths);

        System.out.println(lists.size());

    }

    static void runAndComputer(Thread[] ths){
        long s1 = System.currentTimeMillis();
        Arrays.asList(ths).forEach(t->t.start());
        Arrays.asList(ths).forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        long s2 = System.currentTimeMillis();
        System.out.println(s2 - s1);
    }
}
