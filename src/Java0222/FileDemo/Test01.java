package Java0222.FileDemo;

import java.io.File;

public class Test01 {
    public static void main(String[] args) {

        //和操作系统有关，在实际中需要注意，windows\linux不一样
        //win:\ linux:/
        //win:; linux: :
        String separator = File.separator;
        String pathSeparator = File.pathSeparator;
        System.out.println(separator);
        System.out.println(pathSeparator);
    }
}
