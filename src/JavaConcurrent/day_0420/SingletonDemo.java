package JavaConcurrent.day_0420;



/**
 * 单线程下的单例是满足要求的，但是多线程情况下就不满足了
 */
public class SingletonDemo {
    /**
     * 多线程情况下，必须加volatile
     *  因为，在对象创建的时候可能会发生指令重排，即对象还没有初始化完毕，就将内存对象赋值给instance
     *  这样返回的可能只是一个内存地址，实际的内容并没有填充，可能会带来一些问题
     *
     *  创建对象的三个步骤
     *      1.分配内存空间
     *      2.初始化对象
     *      3.将内存地址赋值给instance
     */
    private volatile static SingletonDemo instance = null;//禁止指令重排

    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName()+"我是构造方法");
    }

    //单线程的单例模式
    public static SingletonDemo getInstance(){
        if(instance == null){
            instance = new SingletonDemo();//也不具有原子性操作
        }
        return instance;
    }

    //多线程的单例模式

    /**
     * DCL(Double Check Lock双从检查机制)
     * 或许你会觉得这种检测已经很完美了，但是可能底层会出现指令重排，那么还是有可能出错
     *
     * DCL的理解：
     *      为什么需要两次判断？
     *          在并发情况下，多个线程竞争同时看到了instance == null，成功通过了第一关
     *          接下来开始synchronized的锁机制，那么此时肯定只有一个线程竞争到锁，进入
     *          同步代码块执行，此时必须进入第二次判断instance == null，因为如果没有进行
     *          第二次判断，阻塞线程一旦拿到锁对象，那么会直接再次new一个对象，这样就不是单例模式
     * @return
     */
    public static SingletonDemo getInstanceCon(){
        if(instance == null){
            synchronized (SingletonDemo.class){
                if(instance == null){
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }



    public static void main(String[] args) {
       // System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());

        //多线程情况下，会出错
        /*for (int i = 0; i < 10 ; i++) {
            new Thread(()->{
                SingletonDemo.getInstance();
            },String.valueOf(i)).start();
        }*/

        System.out.println("--------------");
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                SingletonDemo.getInstanceCon();
            },String.valueOf(i)).start();
        }
    }
}
