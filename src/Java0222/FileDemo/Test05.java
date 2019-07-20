package Java0222.FileDemo;

import java.io.File;
import java.io.IOException;

/**
 * File类中创建删除方法
 * boolean createNewFile()
 *           当且仅当不存在具有此抽象路径名指定名称的文件时，不可分地创建一个新的空文件。
 * boolean delete()
 *           删除此抽象路径名表示的文件或目录。注意：文件或者文件夹都可以操作的，直接在硬盘上删除，不走回收站
 * boolean mkdir()
 *           创建此抽象路径名指定的目录。单级文件夹
 * boolean mkdirs()
 *           创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。可以单级也可以多级
 */
public class Test05 {
    public static void main(String[] args) {
        //show01();
        //show02();
        show03();
        show04();
    }

    private static void show04() {
        File f1 = new File("newDirtectory\\dirtectory1.txt");//创建的是文件夹，而不是文件
        boolean mkdirs = f1.mkdirs();
        System.out.println(mkdirs);

    }

    private static void show03() {
        File f1 = new File("newDirtectory");
        boolean mkdir = f1.mkdir();
        System.out.println(mkdir);
    }

    private static void show02() {
        File f1 = new File("newFile.txt");
        boolean delete = f1.delete();
        System.out.println(delete);
    }

    private static void show01() {
        File f1 = new File("newFile.txt");
        boolean newFile = false;
        try {
            newFile = f1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(newFile);

    }
}
