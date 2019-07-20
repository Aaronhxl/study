package Java0222.FileDemo;

import java.io.File;

/**
 * File类中的判断功能
 *  boolean isDirectory()
 *           测试此抽象路径名表示的文件是否是一个目录。
 *  boolean isFile()
 *           测试此抽象路径名表示的文件是否是一个标准文件。
 *  boolean exists()
 *           测试此抽象路径名表示的文件或目录是否存在。
 */
public class Test04 {
    public static void main(String[] args) {
        show01();

    }

    private static void show01(){
        File f1 = new File("E:\\idea\\ideaProject\\ClassStudy");
        boolean directory = f1.isDirectory();
        System.out.println(directory);

        File f2 = new File(f1,"jian.iml");
        boolean file = f2.isFile();
        System.out.println(file);

        File f3 = new File("a.txt");
        boolean exists = f3.exists();
        System.out.println(exists);
    }
}
