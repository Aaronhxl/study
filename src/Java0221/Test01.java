package Java0221;


/**
 * 多线程的再次理解
 */
public class Test01 {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println("Before Main:"+i);
        }
        System.out.println("多线程开启之前"); //从这里开始，才开辟了多线程，开始争cpu资源
        MyThread myThread = new MyThread();
        myThread.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("After Main:"+i);
        }
        System.out.println("多线程开启之后");
    }
}
