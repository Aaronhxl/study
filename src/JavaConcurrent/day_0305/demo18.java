package JavaConcurrent.day_0305;


import java.util.concurrent.TimeUnit;

/**
 * 锁定某对象o，如果o的属性发生改变，不影响锁的使用
 * 但是如果o变成另外一个对象，则锁定的对象发生改变
 * 应该避免将锁定对象的引用变成另外对象
 *
 * 每个方法中的栈帧，开始只有一个锁对象，被t1使用，后面将o的指向变量，但是线程1中的锁对象没有改变，所以线程还是会运行
 *
 * 同步代码一旦加锁后，那么会有一个临时的锁引用执行锁对象，和真实的引用无直接关联
 * 在锁未释放之前，修改锁对象引用，不会影响同步代码的执行
 */
public class demo18 {

    Object o = new Object();
    void m(){
        synchronized (o){
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        demo18 t = new demo18();

        new Thread(t::m,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(t::m,"t2").start();
        t.o = new Object();


    }
}
