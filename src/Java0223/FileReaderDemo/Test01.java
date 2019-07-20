package Java0223.FileReaderDemo;

import java.io.FileReader;
import java.io.IOException;

/**
 * 学习使用FileReader，字符流来读取文件
 *
 * 构造方法：
 *          FileReader(File file)
 *           在给定从中读取数据的 File 的情况下创建一个新 FileReader。
 *          FileReader(FileDescriptor fd)
 *           在给定从中读取数据的 FileDescriptor 的情况下创建一个新 FileReader。
 *          FileReader(String fileName)
 *           在给定从中读取数据的文件名的情况下创建一个新 FileReader。
 *  方法：
 *          没有本身的方法，从父类中继承
 *          void close()
 *           关闭该流并释放与之关联的所有资源。
 *          String getEncoding()
 *           返回此流使用的字符编码的名称。
 *          int read()
 *           读取单个字符。
 *          int read(char[] cbuf, int offset, int length)
 *           将字符读入数组中的某一部分。
 *          boolean ready()
 *           判断此流是否已经准备好用于读取。
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("b.txt");

        //方式一：单个读取
//        int len = fileReader.read();
//        while(len!=-1){
//            System.out.print((char)len);//可直接编程字符
//            len = fileReader.read();
//        }
//        len = fileReader.read();
//        System.out.println(len); //读到末尾输出 -1
        //方式二：字符缓冲区读取，速度快
        int len = -1;
        char[] cs = new char[1024];
        while ((len = fileReader.read(cs))!=-1){
            System.out.println(new String(cs,0,len));
        }

        fileReader.close();
    }
}
