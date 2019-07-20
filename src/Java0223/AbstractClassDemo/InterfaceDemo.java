package Java0223.AbstractClassDemo;

/**
 * 测试接口特性
 */
public interface InterfaceDemo {
    public static final int data = 1;
   void function();
   default void function1(){
       System.out.println(11);
   }
}
