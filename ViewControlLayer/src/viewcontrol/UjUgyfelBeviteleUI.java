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

    private JPanel megszPanel;
    private JPanel vezPanel;

    public UjUgyfelBeviteleUI(Framework framework){

        this.framework = framework;
        ujUgyfel = new JFrame("Új ügyfél bevitele");
        ujUgyfelBevitelePanel=new JPanel();



        title=new JLabel("Új ügyfél hozzáadása");
        title.setBounds(600,20,100,25);
        title.setFont(new Font("Arial",Font.BOLD,25));

        megszolitasLabel=new JLabel("Megszólítás kiválasztása:");
        megszolitasLabel.setBounds(20,60,100,25);

        jComboBox=new JComboBox();
        jComboBox.addItem("id");
        jComboBox.addItem("ifj");
        jComboBox.addItem("dr");
        jComboBox.setBounds(160,60,100,25);

        vezetekNevLabel=new JLabel("Vezetéknév:");
        vezetekNevLabel.setBounds(20,90,100,25);
        vezetekNevTextfield=new JTextField();
        vezetekNevTextfield.setBounds(160,90,100,25);
        vezetekNevTextfield.setToolTipText("Set last name");

        keresztNevLabel=new JLabel("Keresztnév:");

        keresztNevTextfield=new JTextField();
        keresztNevTextfield.setToolTipText("Set first name");

        emailLabel=new JLabel("E-mail:");
        emailTextfield=new JTextField();

        telefonLabel=new JLabel("Telefon:");
        telefonTextfield=new JTextField();

        //megszPanel=new JPanel();
        //megszPanel.add(megszolitasLabel);
        //megszPanel.add(jComboBox);

        //vezPanel=new JPanel();
        //vezPanel.add(vezetekNevLabel);
        //vezPanel.add(vezetekNevTextfield);

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
