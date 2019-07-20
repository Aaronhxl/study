package Java0222.Thread_Synchornized;

/**
 * 这是测试类
 * 生产者与消费者问题
 */
public class Test {
    public static void main(String[] args) {

        BaoZi baoZi = new BaoZi();
        BaoZiPu baoZiPu = new BaoZiPu(baoZi);
        ChiHuo chiHuo = new ChiHuo(baoZi);

        baoZiPu.start();
        chiHuo.start();

    }
}
