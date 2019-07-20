package Java_init;


public class Test01 {

    private static int a = 0;
    static {
        a = 2;
        System.out.println("静态块");
    }

    public Test01(){
        System.out.println("构造块");
    }

    {
        System.out.println("普通块");
    }
    public static void main(String[] args) {
        new Test01();
    }
}
