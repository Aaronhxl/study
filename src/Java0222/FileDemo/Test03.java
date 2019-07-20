package Java0222.FileDemo;

import java.io.File;

/**
 * File类的获取功能
 * String getAbsolutePath()返回此抽象路径名的绝对路径名字符串
 *
 * String getPath() 将此抽象路径名转换为一个路径名字符串。 绝对返回绝对，相对返回相对
 *
 * String getName() 返回由此抽象路径名表示的文件或目录的名称。实际上就是返回结尾部分，要不是文件，要不是文件夹
 *
 * long length() 返回由此抽象路径名表示的文件的长度。 对文件名没有效果，要是路径错误，则返回0,以字节为单位
 * 注意：toString()方法实际上调用的就是getPath方法
 */
public class Test03 {
    public static void main(String[] args) {
        show01();
        show02();
        show03();
        show04();
    }

    private static void show01(){
        File f1 = new File("a.txt");
        String absolutePath = f1.getAbsolutePath();
        System.out.println(absolutePath);
    }

    private static void show02(){
        File f1 = new File("a.txt");
        String name = f1.getPath();
        System.out.println(name);

        File f2 = new File("E:\\idea\\ideaProject\\ClassStudy\\a.txt");
        String name1 = f2.getPath();
        System.out.println(name1);
    }

    private static void show03(){
        File f1 = new File("a.txt");
        String name = f1.getName();
        System.out.println(name);

        File f2 = new File("E:\\idea\\ideaProject\\ClassStudy\\a.txt");
        String name1 = f2.getName();
        System.out.println(name1);
    }

    private static void show04(){
        File f1 = new File("E:\\idea\\ideaProject\\ClassStudy\\jian.iml");
        long length = f1.length();
        System.out.println(length);
    }

}
