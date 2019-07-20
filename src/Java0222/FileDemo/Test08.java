package Java0222.FileDemo;

import java.io.File;

/**
 * 指定的文件
 */
public class Test08 {
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
            String name = root.getName();
            name = name.toLowerCase();//优化，忽略大小写
            if(name.endsWith(".java")){
                System.out.println(root);
            }
        }

    }
}
