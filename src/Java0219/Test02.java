package Java0219;

/**
 * 多线程程序
 */
public class Test02 {
    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("main:"+i);
        }
    }
}
