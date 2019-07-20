package Java0219;

/**
 * 单线程程序
 */
public class Test01 {
    public static void main(String[] args) {
        Student s1 = new Student("小强");
        s1.run();
        System.out.println(0/0);
        Student s2 = new Student("小黄");
        s2.run();
    }
}
