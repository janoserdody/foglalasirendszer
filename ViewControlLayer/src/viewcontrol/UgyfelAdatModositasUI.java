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
    private JLabel gyerekekSzamaLabel;
    private JComboBox gySzamaComboBox;
    private JLabel lblCegnev;
    private JTextField cegnevTextField;
    private JLabel lblSzamlaCim;
    private JTextField szamlacimTextfield;
    private JButton btnAdatokModositasa;


    public UgyfelAdatModositasUI(Framework framework){
        this.framework = framework;
        asztalok = new JFrame("Asztalok");
        asztalokPanel=new JPanel();
        asztalok.getContentPane();
        asztalokPanel.setLayout(null);

        String[] kodArray={"A2","A4","A5","A6","A7","A8"};


        Font iFont=new Font("Arial",Font.ITALIC,20);



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
        title.setBounds(350,20,cimSize.width,cimSize.height);
        title.setFont(new Font("Arial",Font.BOLD,30));


        megszolitasLabel=new JLabel("Megszólítás kiválasztása:");
        megszolitasLabel.setBounds(30,140,adatokSize.width,adatokSize.height);
        megszolitasLabel.setFont(adatokFont);

        jComboBox=new JComboBox();
        jComboBox.addItem("id");
        jComboBox.addItem("ifj");
        jComboBox.addItem("dr");
        jComboBox.setBounds(400,140,50,adatokSize.height);

        vezetekNevLabel=new JLabel("Vezetéknév:");
        vezetekNevLabel.setBounds(30,200,adatokSize.width,adatokSize.height);
        vezetekNevLabel.setFont(adatokFont);

        vezetekNevTextfield=new JTextField();
        vezetekNevTextfield.setBounds(400,200,adatokSize.width,adatokSize.height);

        keresztNevLabel=new JLabel("Keresztnév:");
        keresztNevLabel.setBounds(30,260,adatokSize.width,adatokSize.height);
        keresztNevLabel.setFont(adatokFont);

        keresztNevTextfield=new JTextField();
        keresztNevTextfield.setBounds(400,260,adatokSize.width,adatokSize.height);

        emailLabel=new JLabel("E-mail:");
        emailLabel.setBounds(30,320,adatokSize.width,adatokSize.height);
        emailLabel.setFont(adatokFont);

        emailTextfield=new JTextField();
        emailTextfield.setBounds(400,320,adatokSize.width,adatokSize.height);

        telefonLabel=new JLabel("Telefon:");
        telefonLabel.setBounds(30,380,adatokSize.width,adatokSize.height);
        telefonLabel.setFont(adatokFont);

        telComboBox=new JComboBox();
        telComboBox.addItem("20");
        telComboBox.addItem("30");
        telComboBox.addItem("70");
        telComboBox.setBounds(400,380,100,25);

        telefonTextfield=new JTextField();
        telefonTextfield.setBounds(520,380,230,adatokSize.height);

        gyerekekSzamaLabel=new JLabel("Gyerekek száma:");
        gyerekekSzamaLabel.setBounds(30,440,adatokSize.width,adatokSize.height);
        gyerekekSzamaLabel.setFont(adatokFont);

        gySzamaComboBox=new JComboBox();
        gySzamaComboBox.addItem("0");
        gySzamaComboBox.addItem("1");
        gySzamaComboBox.addItem("2");
        gySzamaComboBox.addItem("3");
        gySzamaComboBox.addItem("4");
        gySzamaComboBox.addItem("5");
        gySzamaComboBox.addItem("6");
        gySzamaComboBox.addItem("7");
        gySzamaComboBox.setBounds(400,440,100,25);

        lblCegnev=new JLabel("Cégnév:");
        lblCegnev.setBounds(30,500,adatokSize.width,adatokSize.height);
        lblCegnev.setFont(adatokFont);

        cegnevTextField=new JTextField();
        cegnevTextField.setBounds(400,500,adatokSize.width,adatokSize.height);

        lblSzamlaCim=new JLabel("Számlázási cím:");
        lblSzamlaCim.setBounds(30,560,adatokSize.width,adatokSize.height);
        lblSzamlaCim.setFont(adatokFont);

        szamlacimTextfield=new JTextField();
        szamlacimTextfield.setBounds(400,560,adatokSize.width,adatokSize.height);

        btnAdatokModositasa=new JButton("Adatok mentése");
        btnAdatokModositasa.setBounds(400,650,280,40);

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
        asztalokPanel.add(gyerekekSzamaLabel);
        asztalokPanel.add(gySzamaComboBox);
        asztalokPanel.add(lblCegnev);
        asztalokPanel.add(cegnevTextField);
        asztalokPanel.add(lblSzamlaCim);
        asztalokPanel.add(szamlacimTextfield);
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
