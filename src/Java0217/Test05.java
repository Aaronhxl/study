package Java0217;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 多个异常处理方式：
 * 1.	多个异常分别处理
 * 2.	多个异常一次捕获，多次处理
 * 3.	多个异常一次捕获，一次处理
 */
public class Test05 {
    public static void main(String[] args) {
        //1.	多个异常分别处理
        int[] arr = {1,2,3};
        try{
            System.out.println(arr[3]);
        }catch (Exception e){
            System.out.println(e);
        }

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        try{
            System.out.println(list.get(3));
        }catch (Exception e){
            System.out.println(e);
        }

        //2.	多个异常一次捕获，多次处理

        try{
           // System.out.println(arr[3]);
            System.out.println(list.get(3));
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }


        //3.	多个异常一次捕获，一次处理
        try{
            System.out.println(arr[3]);
            System.out.println(list.get(3));
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println("后续代码");
    }
}
