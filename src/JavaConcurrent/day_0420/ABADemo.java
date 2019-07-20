package JavaConcurrent.day_0420;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 此案例演示ABA问题
 *
 *  并利用基于版本号的办法解决ABA问题
 */

public class ABADemo {

    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);

    //这里引出带时间戳的原子类
    static AtomicStampedReference<Integer> atomicStampedReference =
            new AtomicStampedReference<>(100,1);//参数1：为初始值，参数2：为初始版本号

    public static void main(String[] args) {


        /*new Thread(()->{
            System.out.println(atomicReference.compareAndSet(100,101)+" "+atomicReference.get());
            System.out.println(atomicReference.compareAndSet(101,100)+" "+atomicReference.get());
        },"线程1").start();


        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100,2019)+" "+atomicReference.get());
        },"线程2").start();*/


        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicStampedReference.compareAndSet(100,101,
                    stamp,stamp+1)+" "+atomicStampedReference.getReference());

            stamp = atomicStampedReference.getStamp();

            System.out.println(atomicStampedReference.compareAndSet(101,100,
                    stamp,stamp+1)+" "+atomicStampedReference.getReference());
        },"线程3").start();


        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicStampedReference.compareAndSet(100,2019,
                    stamp,stamp+1)+" "+atomicStampedReference.getReference());
        },"线程4").start();
    }
}
