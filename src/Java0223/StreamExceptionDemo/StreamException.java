package Java0223.StreamExceptionDemo;

import java.io.FileWriter;
import java.io.IOException;

/**
 * jdk1.7以前使用的方法
 * 流在使用中不使用throws来处理异常,使用try...catch...finally来处理异常
 */
public class StreamException {
    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter("b.txt",true);
            fileWriter.write("huanglong");

        }catch (Exception e){
            System.out.println(e);
        }finally {
            if(fileWriter!=null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
