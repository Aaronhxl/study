package Java0222.FileDemo;

import java.io.File;

/**
 * 文件过滤器的使用
 * String[] list(FilenameFilter filter)
 *           返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中满足指定过滤器的文件和目录。
 * File[] listFiles(FilenameFilter filter)
 *           返回抽象路径名数组，这些路径名表示此抽象路径名表示的目录中满足指定过滤器的文件和目录。
 */
public class Test09 {
    public static void main(String[] args) {
        File[] files = File.listRoots();
        for (File file : files) {
            System.out.println(file);
        }
    }

}
