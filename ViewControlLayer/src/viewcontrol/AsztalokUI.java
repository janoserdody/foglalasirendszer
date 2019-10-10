package viewcontrol;

import modellayer.Framework;

import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;

public class AsztalokUI {

    private String asztalKod;

    private Framework framework;
    private JFrame asztalok;
    private JPanel asztalokPanel;

    private JLabel title;
    private JMenuBar menuBar;
    private JLabel asztalKodLabel;
    private JTextField asztalKodTextField;
    private JButton elkuldButton;


    public AsztalokUI(Framework framework){
        this.framework = framework;
        asztalok = new JFrame("Asztalok");
        asztalokPanel=new JPanel();
        asztalok.getContentPane();
        asztalokPanel.setLayout(null);

        Font iFont=new Font("Arial",Font.ITALIC,20);

        title=new JLabel("Foglalás bevitele");
        title.setBounds(350,20,400,35);
        title.setFont(new Font("Arial",Font.BOLD,30));



        ImageIcon background=new ImageIcon("tableview.jpg");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(900,600,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
        back.setLayout(null);
        back.setBounds(40,60,900,600);

        menuBar=new JMenuBar();
        menuBar.setBounds(40,665,900,90);

        asztalKodLabel=new JLabel("Foglalni kívánt asztal kódja:");

        asztalKodTextField=new JTextField();

        elkuldButton=new JButton("Asztal lefoglalása");

        menuBar.add(asztalKodLabel);
        menuBar.add(asztalKodTextField);
        menuBar.add(elkuldButton);

        asztalokPanel.add(title);
        asztalokPanel.add(back);
        asztalokPanel.add(menuBar);

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
