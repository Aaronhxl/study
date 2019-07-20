package Java_init;

/**
 * 参考：https://blog.csdn.net/dupengshixu/article/details/75030068
 *
 * 准备阶段：为变量等分配空间以及赋JVM初值、final代码
 * 初始化：static代码（static变量、static代码块）
 * 实例化：非static代码（非static、非final变量、普通代码块、构造方法（最后执行））
 */
public class StaticTest {
    public static int k = 0;// 1
    public static StaticTest s1 = new StaticTest("s1");// 2
    public static StaticTest s2 = new StaticTest("s2");// 3
    public static int i = print("i");// 4
    public static int n = 99;// 5
    public int j = print("j");// 6

    {
        print("构造块");
    }// 7

    static {
        print("静态块");
    }// 8

    public static int print(String s) {
        //System.out.println(s1 +""+ s2);
        System.out.println(++k + ":" + s + "\ti=" + i + "\tn=" + n + "\tprint");
    ++n;
    return ++i;
    }

    public StaticTest(String s) {
        System.out.println(++k + ":" + s + "\ti=" + i + "\tn=" + n + "\tStaticTest");
        ++i;
        ++n;
    }// 9

    public static void main(String[] args) {
        new StaticTest("init");
    }

}


