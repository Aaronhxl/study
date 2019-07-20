package Java0225;

public class FU {
    int num = 10;

    static {
        System.out.println("Fu的静态代码块");
    }
    {
        System.out.println("Fu的成员代码块3");
    }

    {
        System.out.println("Fu的成员代码块1");
    }

    {
        System.out.println("Fu的成员代码块2");
    }

    public FU(){
        System.out.println("Fu的构造方法");
    }

    public void fun1() {
        System.out.println("Fu_fun1");
    }

    public void fun3() {
        System.out.println("Fu_fun3");
    }


    public FU fun4(){
        System.out.println("方法重写测试");
        return new FU();
    }
}
