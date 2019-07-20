package Java0304;

/**
 * 内部类的复习案例：
 * 内部类之所以能获取到外部类的成员,是因为他能获取到外部类的引用。外部类名.this
 *
 */
public class InnerClass {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.fun();

    }
}

class Outer{

    private int num = 30;
    public void fun(){
        int num = 20;
        class inner{ //内部类的作用域

            private int num = 10;

           public void methodInner() {
               System.out.println(num);
            }
        }
        inner inner = new inner();
        inner.methodInner();
        System.out.println(inner.num);
        System.out.println(num);
        System.out.println(Outer.this.num);
    }




}