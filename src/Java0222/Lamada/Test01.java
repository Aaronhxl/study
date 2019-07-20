package Java0222.Lamada;

/**
 * 匿名内部类创建多线程与Lamada表达式创建多线程
 */
public class Test01 {
    public static void main(String[] args) {
        //匿名内部类创建多线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "正在执行任务");
            }
        }).start();
        //匿名内部类创建多线程
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "正在执行任务");
            }
        }.start();
        //Lamada表达式创建多线程
        new Thread(()-> {
            System.out.println(Thread.currentThread().getName() + "正在执行任务");
        }).start();

    }
}
