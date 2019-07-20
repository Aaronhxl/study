package Java0222.Lamada;

/**
 * 使用Calculator的接口
 */
public class Test04 {
    public static void main(String[] args) {
        //使用匿名内部类
        invokeCal(20, 30, new Calculator() {
            @Override
            public int add(int a, int b) {
                return a+b;
            }
        });

        //使用Lamada表达式
        invokeCal(120,130,(int a,int b)->{
            return a+b;
        });
    }

    public static void invokeCal(int a,int b,Calculator c){
        int sum = c.add(a,b);
        System.out.println(sum);
    }
}
