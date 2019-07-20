package Java0219;

public class Student {

    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public void run(){
        for (int i = 0; i < 20; i++) {
            System.out.println(name+" "+i);
        }
    }
}
