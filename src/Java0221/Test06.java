package Java0221;

/**
 * 匿名内部类创建多线程方式
 */
public class Test06 {

    public static void main(String[] args) {
        //Thread类方式
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName()+i);
                }
            }
        }.start();
        //Runnable方式
        new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName()+i);
                }
            }
        }).start();

        new Thread(){
            @Override
            public void run() {
                super.run();
            }
        }.start();

    }
}
