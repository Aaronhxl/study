package Java1222;

public class CloneDome implements Cloneable {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public CloneDome clone() throws CloneNotSupportedException {

        return (CloneDome) super.clone();
    }
}
