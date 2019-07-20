package Java0312;

/**
 * Integer 和 int 之间的比较
 * 对于两个非new生成的Integer对象，进行比较时，
 * 如果两个变量的值在区间-128到127之间，则比较结果为true，
 * 如果两个变量的值不在此区间，则比较结果为false
 */
public class Test01 {
    public static void main(String[] args) {

        Integer i1 = new Integer(100);//堆中

        Integer i2 = 100;//常量池中，方法区
        Integer i3 = 100;//常量池中，方法区,(-128,127)
        Integer i4 = 128;
        Integer i6 = 128;
        System.out.println(i4 == i6);

        int i5 = 100;//int类型与integer相比，只要是值相等那么就是相等的，又自动拆箱


        System.out.println(i1 == i2);
        System.out.println(i2 == i3);

        System.out.println(i1 == i5);
        System.out.println(i2 == i5);

    }
}
