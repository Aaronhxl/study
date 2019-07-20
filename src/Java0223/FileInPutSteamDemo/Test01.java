package Java0223.FileInPutSteamDemo;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * FileInputStream类：
 *
 * 构造方法：
 *      FileInputStream(File file)
 *           通过打开一个到实际文件的连接来创建一个 FileInputStream，该文件通过文件系统中的 File 对象 file 指定。
 *      FileInputStream(String name)
 *           通过打开一个到实际文件的连接来创建一个 FileInputStream，该文件通过文件系统中的路径名 name 指定。
 *
 *       read函数，每读完一个字节会自动往下移动
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("b.txt");
        int read = fileInputStream.read();
        System.out.println(read);
        int read1 = fileInputStream.read();
        System.out.println(read1);
        fileInputStream.close();
    }
}
