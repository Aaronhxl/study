package Java0223.AbstractClassDemo;

public class Cat extends Animal {

    public Cat(){
        System.out.println("Cat的构造方法执行了");
    }

    @Override
    protected void fun2() {
        System.out.println("protected");
    }

    @Override
    public void fun3() {
        System.out.println("public");
    }

    public void fun4(){
        System.out.println("Cat自己的函数");
    }
}
