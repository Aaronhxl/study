package Java0223.FileOutPutStreamDemo;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 一次写入多个字节数据：
 *  void write(byte[] b)
 *           将 b.length 个字节从指定 byte 数组写入此文件输出流中。
 *  void write(byte[] b, int off, int len)
 *           将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此文件输出流。 (写字节数组的一部分，写入输出流中，写入硬盘)
 *
 *  注意：显示的时候会转化为字符（两个字节）：
 *      要是第一个字节为正数（0-127），则会查询ASCII表
 *      要是为负数，则会查询系统默认的表，windows:GBK
 */
public class Test02 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("b.txt");
        /**
         * 有一个方法String类中，getBytes();
         */
        String s = "你好";
        fileOutputStream.write(s.getBytes());


        //byte[] bytes = {67,65,78,98};
        byte[] bytes = {-67,65,78,98,67};
        fileOutputStream.write(bytes,1,2);
        fileOutputStream.close();
    }
}
