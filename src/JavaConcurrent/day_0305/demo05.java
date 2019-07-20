package JavaConcurrent.day_0305;

/**
 * 分析此阿列程序的输出
 */
public class demo05 implements Runnable {

    private static int count = 10;


    @Override
    public synchronized void run() { //加了synchronized关键字相当于此代码块成为了一个原子操作，不能被打断
        count--;
        System.out.println(Thread.currentThread().getName()+" count= "+count);
    }

    public static void main(String[] args) {
        demo05 t = new demo05();
        for (int i = 0; i < 5; i++) {
            new Thread(t,"Thread"+i).start();
        }
    }
}
