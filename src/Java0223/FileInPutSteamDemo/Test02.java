package Java0223.FileInPutSteamDemo;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 读取方法：
 *          int read()              单字节读取到-1，为结束
 *           从此输入流中读取一个数据字节。
 *          int read(byte[] b)
 *           从此输入流中将最多 b.length 个字节的数据读入一个 byte 数组中。
 *          int read(byte[] b, int off, int len)
 *           从此输入流中将最多 len 个字节的数据读入一个 byte 数组中。
 *          long skip(long n)
 *           从输入流中跳过并丢弃 n 个字节的数据。
 *
 * 补充：String类中的两个将byte[]转化为string的构造方法
 *  String(byte[] bytes)
 *           通过使用平台的默认字符集解码指定的 byte 数组，构造一个新的 String。
 *  String(byte[] bytes, int offset, int length)
 *           通过使用平台的默认字符集解码指定的 byte 子数组，构造一个新的 String
 */
public class Test02 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("b.txt");
//        int data = 0;
//        while ((data = fileInputStream.read())!=-1){
//            System.out.print((char)data);
//        }
//        System.out.println();
        byte[] bytes = new byte[20];
        int read = fileInputStream.read(bytes);//读取的有效个数
        System.out.println(read);
        System.out.println(new String(bytes,0,15));//这样可以转换为中文
        fileInputStream.close();
    }
}
