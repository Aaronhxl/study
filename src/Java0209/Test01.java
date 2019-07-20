package Java0209;

import java.time.LocalDate;

public class Test01 {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();
        int day = localDate.getDayOfMonth();
        int mouth = localDate.getMonthValue();

        System.out.println(year+"-"+mouth+"-"+day);
    }
}
