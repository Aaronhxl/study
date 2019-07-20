package JavaConcurrent.day_0420;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 案例说明：验证volatile关键字的三大特性：
 *          1.保证可见性
 *          2.不保证原子性
 *          3.禁止指令重排
 */

public class VolatileDemo {

    class Mydata{
        int number = 0;//共享变量

        //验证保证可见性
        public void AddTo60(){
            this.number = 60;//本身的操作具有原子性
        }

        //验证不保证原子性
        public void AddPlusPlus(){
            number++;//本身的操作不具有原子性
        }

        AtomicInteger atomicInteger = new AtomicInteger();//默认为0

        /**
         * 这样就能保证其原子性
         */
        public void AddAtomInteger(){
            atomicInteger.getAndIncrement();
        }


        public  boolean flag = false;

        /**
         * 验证指令重排
         */
        public void methond01(){
            number = 1;
            flag = true;
        }

        public void methond02(){
            if (flag){
                number = number + 5;
                System.out.println(number);
            }
        }


    }


    public static void main(String[] args) throws InterruptedException {

        //验证保证可见性
       // seeOKVolatile();


        //验证原子性
        AtomNotOk();


    }


    /**
     *  1 验证其的可见性
     */
    public static void seeOKVolatile(){
        VolatileDemo.Mydata demo = new VolatileDemo().new Mydata();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+demo.number);
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                demo.AddTo60();
                System.out.println(Thread.currentThread().getName()+demo.number);
            }
        });
        t1.start();

        while (demo.number == 0){
            //要是线程可见，那么将会跳出死循环
        }

        System.out.println("mission is over");
    }

    /**
     * 2.验证volatile不保证原子性
     *
     *      如何保证其原子性？
     *          ①加synchronized
     *          ②使用并发原子类
     */
    public static void AtomNotOk(){
        VolatileDemo.Mydata demo = new VolatileDemo().new Mydata();

        for (int i = 0; i < 20; i++) {

            new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    demo.AddPlusPlus();
                    demo.AddAtomInteger();
                }
            },String.valueOf(i)).start();
        }

        //后台线程至少为2个，一个GC一个Main
        while (Thread.activeCount()>2){
            Thread.yield();//礼让线程
        }

        System.out.println(Thread.currentThread().getName()+" : "+demo.number);
        System.out.println(Thread.currentThread().getName()+" : " + demo.atomicInteger);
    }
}
