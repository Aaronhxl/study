package Java0225;

public class Zi extends FU {
    int num = 20;
    int age = 30;

    static {
        System.out.println("Zi的静态代码块");
    }

    {
        System.out.println("Zi的成员代码块3");
    }
    {
        System.out.println("Zi的成员代码块1");
    }
    {
        System.out.println("Zi的成员代码块2");
    }

    public Zi(){
        System.out.println("Zi的构造方法");
    }

    @Override
    public void fun1() {
        System.out.println("Zi_fun1");
    }

    public void fun2() {
        System.out.println("Zi_fun2");
    }

    @Override
    public Zi fun4() {
        return new Zi();
    }
}
