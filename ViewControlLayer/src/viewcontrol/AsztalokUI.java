package viewcontrol;

import modellayer.Framework;

import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.Arrays;

public class AsztalokUI {

    private String asztalKod;
    private int szabadAsztalSzam;


    private Framework framework;
    private JFrame asztalok;
    private JPanel asztalokPanel;

    private JLabel title;
    private JMenuBar menuBar;
    private JLabel asztalKodLabel;
    private JLabel szabadAsztalInfoLabel;
    private JTextField szabadAsztalInfoTextField;

    private JTextField asztalKodTextField;
    private JButton elkuldButton;





    public AsztalokUI(Framework framework){
        this.framework = framework;
        asztalok = new JFrame("Asztalok");
        asztalokPanel=new JPanel();
        asztalok.getContentPane();
        asztalokPanel.setLayout(null);

        String[] kodArray={"A2","A4","A5","A6","A7","A8"};


        Font iFont=new Font("Arial",Font.ITALIC,20);

        title=new JLabel("Foglalás bevitele");
        title.setBounds(350,20,400,35);
        title.setFont(new Font("Arial",Font.BOLD,30));



        ImageIcon background=new ImageIcon("tableview.jpg");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(800,500,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
        back.setLayout(null);
        back.setBounds(90,110,800,500);



        asztalKodLabel=new JLabel("Foglalni kívánt asztal kódja:");
        asztalKodLabel.setBounds(90,630,200,20);

        asztalKodTextField=new JTextField();
        asztalKodTextField.setBounds(270,630,50,20);

        szabadAsztalInfoLabel=new JLabel("Szabad .. kódú asztal száma:");
        szabadAsztalInfoLabel.setBounds(90,660,200,20);

        szabadAsztalInfoTextField=new JTextField();
        szabadAsztalInfoTextField.setBounds(270,660,50,20);

        elkuldButton=new JButton("Asztal lefoglalása");
        elkuldButton.setBounds(610,700,280,40);

        /*
        asztalKod=asztalKodTextField.getText();
        szabadAsztalSzam=Integer.parseInt(szabadAsztalInfoTextField.getText());
        */



        asztalokPanel.add(title);
        asztalokPanel.add(back);

        asztalokPanel.add(asztalKodLabel);
        asztalokPanel.add(asztalKodTextField);
        asztalokPanel.add(szabadAsztalInfoLabel);
        asztalokPanel.add(szabadAsztalInfoTextField);
        asztalokPanel.add(elkuldButton);
    }

    public JFrame getAsztalok() {
        return asztalok;
    }

    public void setAsztalok(JFrame asztalok) {
        this.asztalok = asztalok;
    }

    public JPanel getAsztalokPanel() {
        return asztalokPanel;
    }

    public void setAsztalokPanel(JPanel asztalokPanel) {
        this.asztalokPanel = asztalokPanel;
    }
}
