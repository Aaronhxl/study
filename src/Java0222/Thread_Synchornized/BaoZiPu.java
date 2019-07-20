package Java0222.Thread_Synchornized;

public class BaoZiPu extends Thread{

    //包子对象，用于锁对象
    private BaoZi baoZi;

    //使用构造方法传入包子对象
    public BaoZiPu(BaoZi baoZi) {
        this.baoZi = baoZi;
    }

    @Override
    public void run() {
        int count = 0;
        while (true){
            synchronized (baoZi){
                if(baoZi.falg){     //如果已经有包子了，则线程进入等待阶段
                    try {
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //此时没有包子，并且被唤醒，则开始做包子
                if(count%2==0){
                    baoZi.pi = "薄皮";
                    baoZi.xian = "三鲜陷";
                }else {
                    baoZi.pi = "厚皮";
                    baoZi.xian = "猪肉陷";
                }
                count++;
                System.out.println("包子铺正在生产"+baoZi.pi+baoZi.xian+"的包子");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //修改包子的状态，唤醒吃货进程
                baoZi.falg=true;
                baoZi.notify();
            }
        }

    }
}
