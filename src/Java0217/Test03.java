package Java0217;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Test03 {
    public static void main(String[] args) throws IOException {
        readFile("c:\\a.txt");
    }

    public static void readFile(String file) throws IOException {
        if(!file.equals("c:\\a.txt")){
            throw new FileNotFoundException("文件找不到");
        }
        if(!file.endsWith(".txt")){
            throw new IOException("。txt异常");
        }
        System.out.println("文件找到了");
    }
}
