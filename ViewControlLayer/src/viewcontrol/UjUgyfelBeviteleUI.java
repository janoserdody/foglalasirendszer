package viewcontrol;

import modellayer.Framework;

import javax.swing.*;
import java.awt.*;

public class UjUgyfelBeviteleUI {
    private Framework framework;
    private JFrame ujUgyfel;
    private JPanel ujUgyfelBevitelePanel;

    private BorderLayout borderLayout;
    private FlowLayout flowLayout;
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
    private JTextField telefonTextfield;
    private JButton keszButton;

    private JPanel megszPanel;
    private JPanel vezPanel;

    public UjUgyfelBeviteleUI(Framework framework){

        this.framework = framework;
        ujUgyfel = new JFrame("Új ügyfél bevitele");
        ujUgyfelBevitelePanel=new JPanel();
        ujUgyfel.getContentPane();
        //ujUgyfelBevitelePanel.setLayout(new FlowLayout());
        //ujUgyfel.getContentPane().add(ujUgyfelBevitelePanel,"Center");
        ujUgyfelBevitelePanel.setLayout(null);

        Font adatokFont=new Font("Arial",Font.BOLD,20);

        Dimension cimSize=new Dimension();
        cimSize.setSize(400,35);
        Dimension adatokSize=new Dimension();
        adatokSize.setSize(350,25);


        title=new JLabel("Új ügyfél hozzáadása");
        title.setBounds(350,20,cimSize.width,cimSize.height);
        title.setFont(new Font("Arial",Font.BOLD,30));


        megszolitasLabel=new JLabel("Megszólítás kiválasztása:");
        megszolitasLabel.setBounds(30,110,adatokSize.width,adatokSize.height);
        megszolitasLabel.setFont(adatokFont);

        jComboBox=new JComboBox();
        jComboBox.addItem("id");
        jComboBox.addItem("ifj");
        jComboBox.addItem("dr");
        jComboBox.setBounds(400,110,50,adatokSize.height);

        vezetekNevLabel=new JLabel("Vezetéknév:");
        vezetekNevLabel.setBounds(30,160,adatokSize.width,adatokSize.height);
        vezetekNevLabel.setFont(adatokFont);

        vezetekNevTextfield=new JTextField();
        vezetekNevTextfield.setBounds(400,160,adatokSize.width,adatokSize.height);

        keresztNevLabel=new JLabel("Keresztnév:");
        keresztNevLabel.setBounds(30,210,adatokSize.width,adatokSize.height);
        keresztNevLabel.setFont(adatokFont);

        keresztNevTextfield=new JTextField();
        keresztNevTextfield.setBounds(400,210,adatokSize.width,adatokSize.height);

        emailLabel=new JLabel("E-mail:");
        emailLabel.setBounds(30,260,adatokSize.width,adatokSize.height);
        emailLabel.setFont(adatokFont);

        emailTextfield=new JTextField();
        emailTextfield.setBounds(400,260,adatokSize.width,adatokSize.height);

        telefonLabel=new JLabel("Telefon:");
        telefonLabel.setBounds(30,310,adatokSize.width,adatokSize.height);
        telefonLabel.setFont(adatokFont);

        telefonTextfield=new JTextField();
        telefonTextfield.setBounds(400,310,adatokSize.width,adatokSize.height);

        keszButton=new JButton("Ügyfél hozzáadása");
        keszButton.setBounds(350,500,280,40);



        ujUgyfelBevitelePanel.add(title);
        ujUgyfelBevitelePanel.add(megszolitasLabel);
        ujUgyfelBevitelePanel.add(jComboBox);
        ujUgyfelBevitelePanel.add(vezetekNevLabel);
        ujUgyfelBevitelePanel.add(vezetekNevTextfield);
        ujUgyfelBevitelePanel.add(keresztNevLabel);
        ujUgyfelBevitelePanel.add(keresztNevTextfield);
        ujUgyfelBevitelePanel.add(emailLabel);
        ujUgyfelBevitelePanel.add(emailTextfield);
        ujUgyfelBevitelePanel.add(telefonLabel);
        ujUgyfelBevitelePanel.add(telefonTextfield);
        ujUgyfelBevitelePanel.add(keszButton);

        ujUgyfel.add(ujUgyfelBevitelePanel);
    }

    public JFrame getUjUgyfel() {
        return ujUgyfel;
    }

    public void setUjUgyfel(JFrame ujUgyfel) {
        this.ujUgyfel = ujUgyfel;
    }

    public JPanel getUjUgyfelBevitelePanel() {
        return ujUgyfelBevitelePanel;
    }

    public void setUjUgyfelBevitelePanel(JPanel ujUgyfelBevitelePanel) {
        this.ujUgyfelBevitelePanel = ujUgyfelBevitelePanel;
    }
}
