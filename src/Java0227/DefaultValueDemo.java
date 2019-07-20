package Java0227;

/**
 * 变量默认值的测试案例
 */
public class DefaultValueDemo {
    public static void main(String[] args) {
        DefaultValue defaultValue = new DefaultValue();
        defaultValue.printInstanceField();
        defaultValue.printStaticField();

    }
}

class DefaultValue {
    // 实例成员变量
    private boolean bool;
    private byte b;
    private short s;
    private char c;
    private int i;
    private long l;
    private float f;
    private double d;
    private String str;
    private String[] strArray;
    // 静态成员变量
    private static boolean boolStatic;
    private static byte bStatic;
    private static short sStatic;
    private static char cStatic;
    private static int iStatic;
    private static long lStatic;
    private static float fStatic;
    private static double dStatic;
    private static String strStatic;
    private static String[] strArrayStatic;

    public void printInstanceField() {
        System.out.println("实例成员变量默认值：");
        System.out.println("boolean:" + bool);
        System.out.println("byte:" + b);
        System.out.println("short:" + s);
        System.out.println("char:" + c);
        System.out.println("int:" + i);
        System.out.println("long:" + l);
        System.out.println("float:" + f);
        System.out.println("double:" + d);
        System.out.println("String:" + str);
        System.out.println("String[]:" + strArray);
    }

    public static void printStaticField() {
        System.out.println("静态成员变量默认值：");
        System.out.println("boolean:" + boolStatic);
        System.out.println("byte:" + bStatic);
        System.out.println("short:" + sStatic);
        System.out.println("char:" + cStatic);
        System.out.println("int:" + iStatic);
        System.out.println("long:" + lStatic);
        System.out.println("float:" + fStatic);
        System.out.println("double:" + dStatic);
        System.out.println("String:" + strStatic);
        System.out.println("String[]:" + strArrayStatic);
    }
}