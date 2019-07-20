package Java0223;

import Java0223.PriorityDemo.priorityDemo;

public class DefaultDemo extends priorityDemo {
    public void fun5(){
        func1();
        func2();
        //func3(); 不能访问到，只有类访问，或者包访问
        //func4(); 不能访问到，证明子类能访问到的只有public protected default
    }
}


class DefaultDemo1  {
    public static void main(String[] args) {
        priorityDemo priorityDemo = new priorityDemo();
        priorityDemo.func1();//只有public能访问到
        //priorityDemo.func2();
        //priorityDemo.func3();
    }
}