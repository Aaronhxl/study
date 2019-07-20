package Java0221;

/**
 * 测试以下两个方法
 * a)	String getName():获取线程的名称
 * b)	Static Thread currentThread():获取当前正在执行的线程对象的引用
 */
public class Test02 {
    public static void main(String[] args) {
        MyThread myThread01 = new MyThread();
        myThread01.start();
        MyThread myThread02 = new MyThread();
        myThread02.start();
        MyThread myThread03 = new MyThread();
        myThread03.start();

        for (int i = 0; i < 20 ; i++) {
            //这里利用方式二
            String current = Thread.currentThread().getName();
            System.out.println(current);
        }


    }
}
