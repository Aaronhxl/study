package Java1227;

/**
 * 匿名内部类的使用和理解
 */
interface Inter{
    void show();
}

class Outer{
    public void method(){
        new Inter(){
            public void show(){
                System.out.println("show");
            }
        }.show();
    }
}

public class Java1227 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.method();

    }

}
