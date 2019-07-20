package Java0222.FileDemo;

import com.sun.scenario.effect.impl.prism.PrReflectionPeer;

import java.io.File;

/**
 * File的构造方法
 */
public class Test02 {
    public static void main(String[] args) {
        file01();
        file02("C:\\","a.txt");
        file03();
    }


    /**
     * File(String pathname)通过将路径名字符串转换为抽象路径名来创建一个新File实例
     * 参数：
     * 	String pathname：字符串的路径名称
     * 	路径可以是以文件结尾，也可以是以文件夹结尾
     * 	路径可以是相对路径，也可以是绝对路径
     * 	路径可以是存在，也可以是不存在
     * 	创建File对象，只是把字符串路径封装为File对象，不考虑路径的真假情况
     *
     */
    private static void file01(){
        File f1 = new File("E:\\idea\\ideaProject\\ClassStudy");//当前项目的根路径，绝对路径
        System.out.println(f1);
        File f2 = new File("a.txt");//相对路径
        System.out.println(f2);
    }

    /**
     * File(String parent,String Child):根据parent路径名字符串和child路径名创建一个新的file实例
     * 参数：
     * 	String parent：父路径
     * 	String child:：子路径
     * 好处：父路径和子路径，可以单独书写，使用起来十分灵活；父路径和子路径都可以变化
     * @param parent
     * @param child
     */
    private static void file02(String parent,String child){
        File f1 = new File(parent,child);
        System.out.println(f1);
    }

    /**
     * File(File parent,String Child):根据parent路径名字符串和child路径名创建一个新的file实例
     *  参数：
     *   File parent：父路径
     *   String child:：子路径
     *   好处：父路径和子路径，可以单独书写，使用起来十分灵活；父路径和子路径都可以变化
     *         父路径是一个file对象，可以使用他的一些方法
     */

    private static void file03(){
        File f1 = new File("D:\\");
        File f2 = new File(f1,"a.txt");
        System.out.println(f2);
    }
}
