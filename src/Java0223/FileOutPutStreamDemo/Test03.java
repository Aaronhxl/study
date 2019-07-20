package Java0223.FileOutPutStreamDemo;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 追加写/换行：FileOutPutStream中的构造方法
 *  FileOutputStream(File file, boolean append)
 *           创建一个向指定 File 对象表示的文件中写入数据的文件输出流。
 *  FileOutputStream(String name, boolean append)
 *           创建一个向具有指定 name 的文件中写入数据的输出文件流。
 *
 *  注意：append为追加写开关
 *        \r\n ：为换行符
 *        要是真的想写入\r\n，则必须\\r\\n
 */
public class Test03 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("b.txt",true);
        String s = "Java";
        for (int i = 0; i < 10; i++) {
            fileOutputStream.write("你好".getBytes());
            fileOutputStream.write("\\r\\n".getBytes());
        }
        fileOutputStream.write(s.getBytes());
        fileOutputStream.close();
    }
}
