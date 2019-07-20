package Java0222.FileDemo;

import java.io.File;

/**
 * 目录功能
 *  String[] list()
 *           返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中的文件和目录。
 *  File[] listFiles()
 *           返回一个抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件。
 *
 *  注意：要是构造方法中的路径不存在，则会抛出空指针异常
 *      隐藏的文件也能找出来
 */
public class Test06 {
    public static void main(String[] args) {
        show();
    }

    private static void show() {
        File f = new File("E:\\idea\\ideaProject\\ClassStudy");
        String[] list = f.list();
        for (String s : list) {
            System.out.println(s);
        }
        File[] files = f.listFiles();
        for (File file : files) {
            System.out.println(file);
        }
    }
}
