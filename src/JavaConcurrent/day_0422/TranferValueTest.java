package JavaConcurrent.day_0422;

/**
 * 值引用交换
 */
public class TranferValueTest {

    public static void tranfer(String str){
        str = "123";//会在创建一个常量，放入常量池，此时方法中的str指向“123”
    }

    public static void tranfer1(StringBuilder str){
        str.append("123");
    }

    public static void main(String[] args) {

        String str = "abc";
        tranfer(str);
        System.out.println(str);//abc,介于String常量的特殊性，原str还是指向“abc”

        StringBuilder str1 = new StringBuilder("abc");//线程不安全
        //StringBuffer 线程安全
        tranfer1(str1);
        System.out.println(str1);
    }
}
