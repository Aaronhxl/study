package JavaConcurrent.day_0405;

public class demo03 implements Runnable {

    int b = 100;

    @Override
    public void run() {

        try {
            m1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    synchronized void m1() throws InterruptedException {

        b = 1000;
        Thread.sleep(500);
        System.out.println("b = "+b);
        System.out.println("m1");
    }

    synchronized void m2() throws InterruptedException {
        Thread.sleep(200);
        b = 2000;
        System.out.println(
                "m2"
        );
    }

    public static void main(String[] args) throws InterruptedException {
        demo03 tt = new demo03();
        Thread t = new Thread(tt);
        t.start();
        tt.m2();
        System.out.println("main thread b = "+tt.b);
    }
}
