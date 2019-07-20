package Java0223.AbstractClassDemo;

/**
 * 定义一个抽象类：
 *      可以包括抽象方法或者普通方法
 */
public abstract class Animal {

    public Animal(){
        System.out.println("Animal抽象类的构造方法执行了");
    }

    private void fun(){

    }
    protected abstract void fun2();
    public abstract void fun3();

}
