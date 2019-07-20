package JavaString;

import java.util.ArrayList;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        String s = sc.nextLine();
        String s1 = s.substring(1,s.length()-1);
        String[] split = s1.split(",");
        for (int i = 0; i <split.length ; i++) {
            int data = Integer.parseInt(split[i]);
            arr.add(data);
        }
        for (int i = 0; i < arr.size() ; i++) {
            int now = i;
            boolean falg = true;
            while (falg){
                if(now>arr.size()||now<0){
                    System.out.println(true);
                    return;
                }else if(arr.get(now) == 0){
                    break;
                }else {
                    now = arr.get(now)+now;
                }
                if(now == i){
                    falg = false;
                }
            }
        }
        System.out.println(false);
    }
}
