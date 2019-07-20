package Java0312;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Test02 {
    public static void main(String[] args) {

        HashMap<String,Integer> arr = new HashMap();
        TreeSet<String> set = new TreeSet<>();
        Fu demo = new Zi();
        Zi zi = new Zi();
        System.out.println(zi.Add(1,2,4));
        System.out.println(zi.Add(1,2));
        System.out.println(demo.Add(1,2));
    }
}

class Fu{
    public int Add(int a ,int b){
        return a+b;
    }
}

class Zi extends Fu {

    public int Add(int a,int b,int c){
        return a+b +c;
    }
}