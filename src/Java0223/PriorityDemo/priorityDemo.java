package Java0223.PriorityDemo;

/**
 * 四大修饰符的访问权限问题：
 *     访问权限   类   包  子类  其他包
 *
 *     public     ∨   ∨   ∨     ∨
 *
 *     protect    ∨   ∨   ∨     ×
 *
 *     default    ∨   ∨   ×     ×
 *
 *     private    ∨   ×   ×     ×
 */
public class priorityDemo {
    public static void main(String[] args) {

    }

    public void func1(){
        System.out.println("public function1");
    }

    protected void func2(){
        System.out.println("protected function2");
    }

    void func3(){
        System.out.println("default function3");
    }

    private  void fun4(){
        System.out.println("private function4");
    }
}

class Zi extends priorityDemo{
    public void fun5(){
        func1();
        func2();
        func3();
        //func4(); 不能访问到，证明子类能访问到的只有public protected default
    }
}


