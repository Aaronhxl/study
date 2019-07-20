package Java0221;

public class MyThread  extends Thread{

    public MyThread(){

    }

    public MyThread(String name){
        super(name);
    }

    @Override
    public void run() {
//        for (int i = 0; i < 20; i++) {
//            System.out.println("MyThread:"+i);
//        }
        //方式一：直接利用getname方法得到线程名称
        String name = getName();
        System.out.println(name);
    }
}
