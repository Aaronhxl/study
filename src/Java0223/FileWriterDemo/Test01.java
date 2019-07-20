package Java0223.FileWriterDemo;

import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriteDemo类的使用：
 * 构造方法：
 *  FileWriter(File file)
 *           根据给定的 File 对象构造一个 FileWriter 对象。
 * FileWriter(File file, boolean append)
 *           根据给定的 File 对象构造一个 FileWriter 对象。
 * FileWriter(String fileName)
 *           根据给定的文件名构造一个 FileWriter 对象。
 * FileWriter(String fileName, boolean append)
 *           根据给定的文件名以及指示是否附加写入数据的 boolean 值来构造 FileWriter 对象。
 *
 *     注意：其实和字节流是一样的
 *
 *  方法：
 *  void close()
 *           关闭此流，但要先刷新它。
 *  void flush()
 *           刷新该流的缓冲。
 *  String getEncoding()
 *           返回此流使用的字符编码的名称。
 *  void write(char[] cbuf, int off, int len)
 *           写入字符数组的某一部分。
 *  void write(int c)
 *           写入单个字符。
 *  void write(String str, int off, int len)
 *           写入字符串的某一部分。
 *
 *   这里直接可以写字符串，不用将字符串转换为字节数组
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("c.txt",true);
        fileWriter.write("黄龙");
        for (int i = 0; i < 10; i++) {
            fileWriter.write("浙江大学"+i);
            fileWriter.write("\r\n");
        }
        fileWriter.flush();
        fileWriter.close();//其实在关闭资源之前也会将数据缓冲区的数据刷新到文件中

    }
}
