package JavaConcurrent.day_0305;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile与synchronized的区别？
 * synchronized可以保证可见性和原子性
 * volatile只能保证可见性
 */

public class demo14 {
     int count = 0;
    synchronized void m(){
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        demo14 t = new demo14();
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
