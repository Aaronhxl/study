package JavaConcurrent.day_0305;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile与synchronized的区别？ 与demo14对比
 * ++操作没有原子性
 */

public class demo13 {
    volatile int count = 0;
    void m(){
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        demo13 t = new demo13();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m,"thread-"+i));
        }
        threads.forEach((o)->o.start());
        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(t.count);
    }
}
