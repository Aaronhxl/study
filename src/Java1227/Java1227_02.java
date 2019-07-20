package Java1227;

interface inter1{
    void show();
}

class Outer1{

    public static inter1 method(){
        return new inter1(){
            @Override
            public void show() {
                System.out.println("helloworld");
            }
        };
    }
}

public class Java1227_02 {
    public static void main(String[] args) {
        //Outer1.method().show();
//         int a = 0X7FFF_FFFF;
////         long b =0X7FFF_FFFF_FFFF_FFFFL;
////         long c= 0X8000_0000_0000_0000L;
////         byte d = (byte) 0x80;
////         long e = 0XF000_0000_0000_0000L;
////         long f = 0X7FFF_FFFF_FFFF_FFFFL;
////        System.out.println(e);
////        System.out.println(f);
////        System.out.println(-f);
////        System.out.println(e-f);
////        System.out.println(f-e);
////
////        System.out.println(a);
////        System.out.println(b);
////        System.out.println(c);
////        System.out.printf("%d",d);
        int a = 0X7FFF_FFFF;
        int b = 0X7FFF_FFFF;
        int c = 0XFFFF_FFFE;
        System.out.println(c);
        System.out.println(a+b);

    }

}
