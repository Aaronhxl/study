package Java0223.StreamExceptionDemo;

import java.io.FileWriter;
import java.io.IOException;

/**
 * JDK9的新特性：
 *
 * 可以在try前面定义流对象，在try(引用前面定义的对象1；对象2；){
 *
 * }catch(){
 *
 * }
 * 也不用再写finally的代码
 *
 * 由于本机上的jdk坂本为jdk8,所以暂时用不了新特性
 */
public class Test03 {
    public static void main(String[] args) throws IOException {
//        FileWriter f  = new FileWriter("b.txt");
//        try(f){
//            f.write("huaglong");
//        }catch (Exception e){
//            System.out.println(e);
//        }
    }
}
