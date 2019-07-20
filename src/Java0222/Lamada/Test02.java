package Java0222.Lamada;

/**
 * 无参的Lamada表达式测试
 */
public class Test02 {
    public static void main(String[] args) {

        //传统利用匿名内部类来实现
        invokeMakeFood(new Cook() {
            @Override
            public void makeFood() {
                System.out.println("我吃饭了");
            }
        });

        //Lamada表表达式实现
        invokeMakeFood(()->{
            System.out.println("Lambda我吃饭了");
        });
    }

    public static void invokeMakeFood(Cook cook){
        cook.makeFood();
    }
}
