package Java0225;

/**
 * 多态中成员方法访问的特点：
 *      看new的是谁，则优先访问谁，没有则向上找
 */
public class MultiplyDemo2 {
    public static void main(String[] args) {
        FU demo1 = new Zi();
        System.out.println("------");
        FU demo2 = new Zi();
        System.out.println("-------");
        Zi demo3 = new Zi();

//        ((Zi)demo).fun2(); //由于Fu中没有含有fun2方法，则编译不通过
//        demo.fun3();
//        demo.fun1();
//        demo.fun1(); // 还是调用的Zi方法，多态就是一种向上转型的体现，访问特点
    }

}
