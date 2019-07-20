package Java0224;

/**
 * String的面试题
 */
public class StringDemo {

    public static void main(String[] args) {

        //demo1:
//        String a = "hello2";
//        String b = "hello"+2;
//        System.out.println(a == b);//true


        //demo2
        /**
         * 输出结果为:false。由于有符号引用的存在，所以  String c = b + 2;不会在编译期间被优化，
         * 不会把b+2当做字面常量来处理的，因此这种方式生成的对象事实上是保存在堆上的。因此a和c指向的并不是同一个对象
         */
//        String a = "hello2";
//        String b = "hello";
//        String c = b + 2;
//        System.out.println(a == c);//false

        //demo3
        /**
         * 对于被final修饰的变量，会在class文件常量池中保存一个副本，也就是说不会通过连接而进行访问，
         * 对final变量的访问在编译期间都会直接被替代为真实的值。
         * 那么String c = b + 2;在编译期间就会被优化成：String c = "hello" + 2;
         */
//        String a = "hello2";
//        final  String b = "hello";
//        String c = b + 2;
//        System.out.println(a == c);//true

        //demo4
        /**
         * 输出结果为false。这里面虽然将b用final修饰了，但是由于其赋值是通过方法调用返回的，
         * 那么它的值只能在运行期间确定，因此a和c指向的不是同一个对象。
         */
//        String a = "hello2";
//        final String b = getHello();
//        String c = b + 2;
//        System.out.println((a == c));//false

        //demo5
        /**
         *在String类中，intern方法是一个本地方法，在JAVA SE6之前，intern方法会在运行时常量池中查找是否存在内容相同的字符串，如果存在则返回指向该字符串的引用，
         * 如果不存在，则会将该字符串入池，并返回一个指向该字符串的引用。因此，a和d指向的是同一个对象。
         */
//        String a = "hello";
//        String b =  new String("hello");
//        String c =  new String("hello");
//        String d = b.intern();
//
//        System.out.println(a==b); //false
//        System.out.println(b==c); //false
//        System.out.println(b==d); //false
//        System.out.println(a==d); //false


        //demo6



    }

    public static String getHello() {
        return "hello";
    }
}
