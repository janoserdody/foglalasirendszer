package viewcontrol;

import modellayer.Framework;

import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.Arrays;

public class UgyfelAdatModositasUI {

    private String asztalKod;
    private int szabadAsztalSzam;


    private Framework framework;
    private JFrame asztalok;
    private JPanel asztalokPanel;

    private JLabel title;
    private JLabel megszolitasLabel;
    private JComboBox jComboBox;
    private JLabel keresztNevLabel;
    private JTextField keresztNevTextfield;
    private JLabel vezetekNevLabel;
    private JTextField vezetekNevTextfield;
    private JLabel emailLabel;
    private JTextField emailTextfield;
    private JLabel telefonLabel;
    private JComboBox telComboBox;
    private JTextField telefonTextfield;
    private JButton btnAdatokModositasa;


    public UgyfelAdatModositasUI(Framework framework){
        this.framework = framework;
        asztalok = new JFrame("Asztalok");
        asztalokPanel=new JPanel();
        asztalok.getContentPane();
        asztalokPanel.setLayout(null);

        String[] kodArray={"A2","A4","A5","A6","A7","A8"};


        Font iFont=new Font("Arial",Font.ITALIC,20);

        title=new JLabel("Ügyfél adatok módosítása");
        title.setBounds(350,20,400,35);
        title.setFont(new Font("Arial",Font.BOLD,30));

        /*
        ImageIcon background=new ImageIcon("tableview.jpg");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(800,500,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
        back.setLayout(null);
        back.setBounds(90,110,800,500);*/


        Font adatokFont=new Font("Arial",Font.BOLD,20);

        Dimension cimSize=new Dimension();
        cimSize.setSize(400,35);
        Dimension adatokSize=new Dimension();
        adatokSize.setSize(350,25);


        title=new JLabel("Ügyfél adat módosítás");
        title.setBounds(350,40,cimSize.width,cimSize.height);
        title.setFont(new Font("Arial",Font.BOLD,30));


        megszolitasLabel=new JLabel("Megszólítás kiválasztása:");
        megszolitasLabel.setBounds(30,170,adatokSize.width,adatokSize.height);
        megszolitasLabel.setFont(adatokFont);

        jComboBox=new JComboBox();
        jComboBox.addItem("id");
        jComboBox.addItem("ifj");
        jComboBox.addItem("dr");
        jComboBox.setBounds(400,170,50,adatokSize.height);

        vezetekNevLabel=new JLabel("Vezetéknév:");
        vezetekNevLabel.setBounds(30,240,adatokSize.width,adatokSize.height);
        vezetekNevLabel.setFont(adatokFont);

        vezetekNevTextfield=new JTextField();
        vezetekNevTextfield.setBounds(400,240,adatokSize.width,adatokSize.height);

        keresztNevLabel=new JLabel("Keresztnév:");
        keresztNevLabel.setBounds(30,310,adatokSize.width,adatokSize.height);
        keresztNevLabel.setFont(adatokFont);

        keresztNevTextfield=new JTextField();
        keresztNevTextfield.setBounds(400,310,adatokSize.width,adatokSize.height);

        emailLabel=new JLabel("E-mail:");
        emailLabel.setBounds(30,380,adatokSize.width,adatokSize.height);
        emailLabel.setFont(adatokFont);

        emailTextfield=new JTextField();
        emailTextfield.setBounds(400,380,adatokSize.width,adatokSize.height);

        telefonLabel=new JLabel("Telefon:");
        telefonLabel.setBounds(30,450,adatokSize.width,adatokSize.height);
        telefonLabel.setFont(adatokFont);

        telComboBox=new JComboBox();
        telComboBox.addItem("20");
        telComboBox.addItem("30");
        telComboBox.addItem("70");
        telComboBox.setBounds(400,450,100,25);

        telefonTextfield=new JTextField();
        telefonTextfield.setBounds(520,450,230,adatokSize.height);

        btnAdatokModositasa=new JButton("Adatok mentése");
        btnAdatokModositasa.setBounds(395,600,280,40);

        asztalokPanel.add(title);
        asztalokPanel.add(title);
        asztalokPanel.add(megszolitasLabel);
        asztalokPanel.add(jComboBox);
        asztalokPanel.add(vezetekNevLabel);
        asztalokPanel.add(vezetekNevTextfield);
        asztalokPanel.add(keresztNevLabel);
        asztalokPanel.add(keresztNevTextfield);
        asztalokPanel.add(emailLabel);
        asztalokPanel.add(emailTextfield);
        asztalokPanel.add(telefonLabel);
        asztalokPanel.add(telComboBox);
        asztalokPanel.add(telefonTextfield);
        asztalokPanel.add(btnAdatokModositasa);
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
