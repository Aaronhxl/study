package Java0221;

/**
 * 创建多线程的第二种实现方式
 */
public class Test05 {

    public static void main(String[] args) {
        RunnableImp runnableImp = new RunnableImp();
        Thread thread = new Thread(runnableImp);
        thread.setName("huang");
        thread.start();

        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
