package Java0223.AbstractClassDemo;

/**
 * 抽象类复习
 */
public class Test01 {

    public static void main(String[] args) {
        Cat cat = new Cat();
        Animal a = new Cat();//也可以使用多态
        a.fun2();
        a.fun3();
        ((Cat)a).fun4();//多态向下转型
    }

}
