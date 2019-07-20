package Java0315;

import java.util.ArrayList;

public class Test01 {
    public static void main(String[] args) {
        System.out.println(true&false);
        ArrayList<String> arr = new ArrayList<>();

        String s = "1j";
        try {
            int i = Integer.parseInt(s);
            System.out.println(i);

        }catch (Exception e){
            e.printStackTrace();
        }



//        long l = Long.parseLong(s);
//        System.out.println(l);
        System.out.println("over");
    }
}
