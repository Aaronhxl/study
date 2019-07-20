package Java0223.FileOutPutStreamDemo;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileOutPutStream的使用
 *
 * 掌握两个构造方法：
 *      FileOutputStream(File file)
 *           创建一个向指定 File 对象表示的文件中写入数据的文件输出流。
 *      FileOutputStream(String name)
 *           创建一个向具有指定名称的文件中写入数据的输出文件流。
 * 构造方法的作用：
 *      1.创建了一个FileOutPutStream对象
 *      2.根据构造方法中的路径创建一个新的空文件
 *      3.将FileOutPutStream对象指向新的空文件
 *
 * 使用步骤：
 *      1.创建FileOutPutStream的对象
 *      2.调用write方法，写入数据
 *      3.关闭流，因为会占资源
 */
public class Test01 {
    public static void main(String[] args) throws IOException {

        //注意到这三个方法均会抛出异常
        FileOutputStream fileOutputStream = new FileOutputStream("a.txt");
        fileOutputStream.write(98);
        fileOutputStream.close();
    }
}
