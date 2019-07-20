package Java0221;

/**
 * 线程安全问题
 */
public class SafeThread {
    public static void main(String[] args) {


        SaleTicket st = new SaleTicket();
        Thread thread1 = new Thread(st);
        thread1.setName("线程1");
        thread1.start();
        Thread thread2 = new Thread(st);
        thread2.setName("线程2");
        thread2.start();
        Thread thread3 = new Thread(st);
        thread3.setName("线程3");
        thread3.start();
    }
}
