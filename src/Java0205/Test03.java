package Java0205;

public class Test03 {
    static{
        int x = 5;
    }
    static int x,y;
    public static void first(){
        y = x++ + ++x;
        System.out.println(y);
        System.out.println(x);
    }

    public static void main(String[] args) {
        x--;
        first();
        System.out.println(x+y+ ++x);
    }
}
