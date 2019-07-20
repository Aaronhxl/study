package Java0221;

/**
 * 设置线程名称两种方式测试
 */
public class Test03 {
    public static void main(String[] args) {
        //方式一：setName方法
        MyThread mt = new MyThread();
        mt.setName("黄龙");
        mt.start();
        //方式二：构造方法
        MyThread mt02 = new MyThread("huanglong");
        mt02.start();
    }

}
