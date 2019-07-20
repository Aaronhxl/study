package Java_init;

import java.sql.SQLOutput;

/**
 * 执行静态的变量和静态的代码块，是从上往下执行的，并不是从变量-》代码块
 */

public class Test {

    private static String name ="1";

    static {

        System.out.println("静态代码块");
        name = "2";
    }


//    {
//        System.out.println("成员代码块");
//        name = "3";
//    }

    public Test(){
        System.out.println("构造方法");
      //  this.name = "4";
        System.out.println(name);
    }

    public static void main(String[] args) {
      //  Test t = new Test();
        System.out.println("mian方法");
        //A_son a = new A_son();
//        System.out.println( A_son.a);
//        System.out.println(A_son.b);


        A_son[] a_sons = new A_son[10]; //并不会被初始化

        System.out.println(A_son.c);
    }
}


class A{

    public static String c ="123";//通过子类访问c,子类并不会被初始化
    static {
        System.out.println("A的静态代码");
    }

    public A(){
        System.out.println("A的构造代码");
    }

}

class A_son extends A{

//    public static final String a ="123"; //引用它不会引起类的加载
//    public static String b = "123";//引用它会引起类的加载

    static {
        System.out.println("A_son的静态代码");
    }

    public A_son(){
        System.out.println("A_sn的构造方法");
    }
}