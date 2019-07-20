package Java1226;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Date;
import javax.swing.*;

public class java1226 {
    public static void main(String[] args) {
        ActionListener timePrint = new TimePrint();
        Timer timer = new Timer(1000,timePrint);
        timer.start();
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }

}

class TimePrint implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone, the time is "+new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}