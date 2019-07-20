package Java0217;

/**
 * finally代码块的用法
 */

public class Test04 {
    public static void main(String[] args) {

        int[] arr = {1,2,3};
        try{
            System.out.println(arr[3]);
            System.out.println("这里为后续代码");//前面发生了异常就执行不到了
        }catch (Exception e){
            System.out.println(e);
        }finally {
            System.out.println("释放资源");
        }
    }
}
