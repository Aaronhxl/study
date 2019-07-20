package JavaConcurrent.day_0305;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *解决同样的问题的更高效的方法，使用AtomXXX类
 * AtomXXX类本身每个方法都是原子性的，当不能保证多个方法连续调用是原子性的
 * 通过底层来实现的，效率较高一点
 */

public class demo15 {
     //int count = 0;
    AtomicInteger count = new AtomicInteger(0);
     void m(){
        for (int i = 0; i < 10000; i++) {
            //count++;
            //if (coutn.get()<1000) 加上这句可能还是会有原子性问题，虽然两条语句都是原子的，但是中间还是会出现问题
            count.incrementAndGet();//= count++,用很底层的方法实现
        }
    }

    public static void main(String[] args) {
        demo15 t = new demo15();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m,"thread-"+i));
        }
        threads.forEach((o)->o.start());
        threads.forEach((o)->{   //这里表示在前面10个线程运行结束之后，才会执行最后那句输出的语句
            try {
                o.join();//接连线程
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(t.count);
    }
}
