package Java0225;

/**
 * 多态的成员变量访问特点：
 *  a)	直接通过对象名称访问成员变量：看等号左边，没有则往上找
 *  b)	间接通过成员方法访问：看该方法属于谁，优先用谁，没有则向上找
 */
public class MultiplyDemo1 {
    public static void main(String[] args) {
        /**
         * 测试多态的成员变量访问特点
         */
        /**
         * 访问变量名相同的变量
         */
        FU demo1 = new Zi();
        System.out.println(demo1.num); // 访问父类的资源
        System.out.println(((Zi) demo1).num); //访问子类的资源

        /**
         * 访问子类特有的变量
         */
        System.out.println(((Zi) demo1).age);//必须向下转型
       // System.out.println(demo1.age); //编译出错
    }
}
