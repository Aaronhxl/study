package JavaConcurrent.day_0305;

/**
 * 不要以字符串常量作为锁定对象
 * 在下面的例子中，m1和m2其实锁定的是同一个对象
 * 这种情况下还会发生比较诡异的现象，比如你用到一个类库，该类库中代码锁定了字符串“hello"
 * 而你并不知道，在自己代码中也用到了”hello",则会发生死锁现象
 */
public class demo19 {
    String s1 = "hello";
    String s2 = "hello";

    void m1(){
        synchronized (s1){

        }
    }

    void m2(){
        synchronized (s2){

        }
    }
}
