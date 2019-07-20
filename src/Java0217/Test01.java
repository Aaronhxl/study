package Java0217;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01 {
    public static void main(String[] args)  {
        //这种称之为编译时异常
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
//        Date date = null;
//        try {
//            date = sdf.parse("2019-0299");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        System.out.println(date);

        //这种是运行时异常
//        int[] arr = {1,2,3};
//        try{
//            System.out.println(arr[3]);
//        }catch (Exception e){
//            e.printStackTrace();
//            System.out.println(e);
//        }

        //这种是Error，必须修改源代码才能解决问题，这里就是不能内存分配太大了，必须改小，否则运行不了
        //int[] arr = new int[1024*1024*1024];

        System.out.println("后续代码");
    }
}
