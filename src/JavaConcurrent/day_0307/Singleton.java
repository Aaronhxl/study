package JavaConcurrent.day_0307;

import java.util.Arrays;

/**
 * 参考文章：http://www.cnblogs.com/xudong-bupt/p/3433643.html
 * 线程安全的单例模式
 *
 * 更好的是采用下面的方式，既不用加锁，也能实现懒加载
 *
 */
public class Singleton {

    private Singleton(){
        System.out.println("single");
    }

    private static class Inner{
        private static Singleton s = new Singleton();
    }

    private static Singleton getSingle(){ //只有在被调用的时候，才loader进入虚拟机，实现初始化
        return Inner.s;
    }

    public static void main(String[] args) {
        Thread[] ths = new Thread[200];
        for (int i = 0; i < ths.length; i++) {
            ths[i] = new Thread(()->{
                Singleton.getSingle();
            });
        }

        Arrays.asList(ths).forEach(o->o.start());

    }


}
