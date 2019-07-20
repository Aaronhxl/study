package Java0224;

/**
 * 可变参数Demo
 * int ... arr :
 * 注意：
 *      1.底层的数据结构是数组
 *      2.一个方法的参数列表只能有一个可变参数
 *      3.如果有多个参数，则可变参数必须放在最后一个
 *      4.可变参数的终极写法：（Object...objects）
 */
public class VaiablePara {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(add(arr));

    }

    private static int add(int ... arr){
        int len = arr.length;
        int sum = 0;
        for (int i = 0; i < len ; i++) {
            sum+=arr[i];
        }
        return sum;
    }
//    private static int add(int ... arr,int v){//错误
//        int len = arr.length;
//        int sum = 0;
//        for (int i = 0; i < len ; i++) {
//            sum+=arr[i];
//        }
//        return sum;
//    }

//    private static int add1(int ... arr,int ... arr1){ //错误
//        int len = arr.length;
//        int sum = 0;
//        for (int i = 0; i < len ; i++) {
//            sum+=arr[i];
//        }
//        return sum;
//    }

}
