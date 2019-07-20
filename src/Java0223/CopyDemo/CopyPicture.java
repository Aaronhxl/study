package Java0223.CopyDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用字节流复制一张图片
 *
 * 速度上可以加快
 */
public class CopyPicture {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\44425\\Pictures\\Saved Pictures\\demo.jpg");
        FileOutputStream fos = new FileOutputStream("demo.jpg");
        int len = 0;
        byte[] bytes = new byte[1024];
        long s = System.currentTimeMillis();
        while ((len = fis.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }
        //先关闭写的，再关闭读的
        fos.close();
        fis.close();
        long e = System.currentTimeMillis();
        System.out.println("复制的耗时："+(e-s)+"毫秒");
    }

}
