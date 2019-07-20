package Java0304;

/**
 * 关于final关键字的复习案例
 * 1.	用来修饰一个类：不能被继承
 * 2.	修饰一个方法：不能被覆盖重写，abstract、final不能同时使用，矛盾
 * 3.	修饰一个局部变量：“一次赋值，终身不变”，就算是一样的值也不行，只要保证有唯一一次赋值就行
 * 4.	修饰一个成员变量
 */
public class FinalDemo{

    public FinalDemo(String name) {
        //this.name = name;

    }

    public void fun() {
       final String  name ;
       int a =  10;
        name = "123";
    }

    public static void main(String[] args) {

    }
}
