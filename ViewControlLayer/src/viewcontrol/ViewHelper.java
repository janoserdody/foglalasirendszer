package viewcontrol;

import javax.swing.*;

public class ViewHelper {

    public void displayFrame(JFrame frame, JPanel panel) {
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1000,800);
    }
}
