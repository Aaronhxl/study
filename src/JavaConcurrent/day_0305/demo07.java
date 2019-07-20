package JavaConcurrent.day_0305;

/**
 * synchronized方法运行过程中，非synchronized方法是可以运行的
 */
public class demo07 {
    public  synchronized  void m1(){
        System.out.println(Thread.currentThread().getName()+" m1 start...");
        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" m1 end...");
    }

    public void m2(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" m2 ");
    }

    public static void main(String[] args) {
        demo07 t = new demo07();
        new Thread(()->t.m1(),"t1").start();
        new Thread(()->t.m2(),"t2").start();

        //这个跟上诉代码是一样的作用
//        new Thread(t::m1,"t1").start();
//        new Thread(t::m2,"t2").start();
    }
}
