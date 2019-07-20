package JavaConcurrent.day_0308;
import java.util.concurrent.Executor;
/**
 * 认识Executor
 * 是线程池的一个顶层接口，只有一个方法，执行任务的，接收一个Runnable对象
 */
public class T01_MyExecutor implements Executor {

    @Override
    public void execute(Runnable command) {

       // new Thread(command).start();启一个线程，去开始调用
        command.run();//直接方法调用
    }

    public static void main(String[] args) {
        new T01_MyExecutor().execute(()-> {
            System.out.println("hello executor");
        });
    }
}
