package Java0223.FileWriterDemo;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

/**
 * flush方法与close方法的区别：
 *      flush：刷新数据缓冲区，流对象还可以继续使用
 *      close：刷新数据缓冲区，通知系统关闭资源，流对象不能再被使用
 */
public class Test02 {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("d.txt",true);
        fileWriter.write("软件学院"+ System.currentTimeMillis());
        fileWriter.flush();
        fileWriter.write("软件学院"+System.currentTimeMillis());
        fileWriter.flush();
        fileWriter.close();
        //fileWriter.write("软件学院"+System.currentTimeMillis()); 这里就不能再使用流对象了

    }
}
