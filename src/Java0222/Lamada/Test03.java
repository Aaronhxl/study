package Java0222.Lamada;

import java.util.Arrays;

/**
 * 使用lamada排序,匿名内部类和Lambda表达式的练习
 */
public class Test03 {
    public static void main(String[] args) {
        Person[] p = {
                new Person("黄龙",23),
                new Person("黄小龙",34),
                new Person("周杰伦",39)
        };

        //匿名内部类的方式
//        Arrays.sort(p, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getAge()-o2.getAge();
//            }
//        });

        //Lamada表达式的方式
        Arrays.sort(p,(Person o1, Person o2)->{
            return o1.getAge()-o2.getAge();
        });
        for (Person person : p) {
            System.out.println(person);
        }
    }
}
