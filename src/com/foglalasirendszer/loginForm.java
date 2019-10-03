package com.foglalasirendszer;


import javax.swing.*;

public class loginForm {
    private JPanel panel1;

    public static void main(String[] args) {
        JFrame frame=new JFrame("foglalasirendszer");
        frame.setContentPane(new loginForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
