package Java0222.Thread_Synchornized;

public class ChiHuo extends Thread{
    //包子对象，用于锁对象
    private BaoZi baoZi;

    //使用构造方法传入包子对象
    public ChiHuo(BaoZi baoZi) {
        this.baoZi = baoZi;
    }

    @Override
    public void run() {
        while (true){
            synchronized (baoZi){ //此时要是没有包子，则线程等待
                if(!baoZi.falg){
                    try {
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //要是没有包子，则吃包子
                System.out.println("吃货正在吃"+baoZi.pi+baoZi.xian+"的包子");
                baoZi.falg = false;
                baoZi.notify();
            }
        }
    }
}
