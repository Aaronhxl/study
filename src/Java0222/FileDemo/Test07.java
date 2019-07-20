package Java0222.FileDemo;

import java.io.File;

/**
 * 递归：要有出口，次数不能太多，否则都会发生栈内存溢出
 * 构造方法禁止递归，直接编译报错了，否则内存中有无数对象
 * Demo：
 *  遍历文件夹
 */
public class Test07 {
    public static void main(String[] args) {
        File root = new File("E:\\idea\\ideaProject\\ClassStudy");
        printFile(root);
    }

    private static void printFile(File root) {

        if(root.isDirectory()){
            File[] files = root.listFiles();
            for (File file : files) {
                printFile(file);
            }
        }else {
            System.out.println(root);
        }

    }

}
