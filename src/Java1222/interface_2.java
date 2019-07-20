package Java1222;

public interface interface_2 extends interface_1 {
    void sayHello();
    void foo();
    void bar();
    default void printf(){
        System.out.println("interface_2");
    };

}
