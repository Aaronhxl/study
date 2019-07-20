package Java0223.StreamExceptionDemo;

import java.io.FileWriter;
import java.io.IOException;

/**
 * jdk7新特性，可以直接在可以在try之后添加（），里面定义流对象，
 * 并且这个流对象只在try中有效，那么我们就可以不用写finally中的代码
 * 自动释放对象
 * try(对象1；对象2...)
 */
public class Test02 {
    public static void main(String[] args) {


        try(FileWriter fileWriter = new FileWriter("b.txt",true);){
            fileWriter.write("huanglong");
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
