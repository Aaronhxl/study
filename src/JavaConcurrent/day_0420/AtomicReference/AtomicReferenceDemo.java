package JavaConcurrent.day_0420.AtomicReference;


import java.util.concurrent.atomic.AtomicReference;

class User{
    private String name;
    private int age;

    public User(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class AtomicReferenceDemo {

    public static void main(String[] args) {

        AtomicReference<User> user = new AtomicReference<>();

        User z3 = new User("z3",23);
        User l4 = new User("l4",23);

        user.set(z3);

        System.out.println(user.compareAndSet(z3,l4));
        System.out.println(user.get().toString());

    }
}
