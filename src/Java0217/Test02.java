package Java0217;

public class Test02 {
    public static void main(String[] args) {

        int[] arr = {1,2,3};
        System.out.println(arr.length);
//        int[] arr = null;
// int element = getElement(arr,0);  //这里的异常处理者为jvm,因为这是RuntimeException
        int element = getElement(arr,3);

        System.out.println(element);

    }

    public static int getElement(int[] arr,int index){

        if(arr == null){
            throw new NullPointerException("传递的数组为NULL");
        }

        if(index < 0||index > arr.length-1){
            throw new ArrayIndexOutOfBoundsException("index越界");
        }
        int element = arr[index];
        return element;
    }
}
