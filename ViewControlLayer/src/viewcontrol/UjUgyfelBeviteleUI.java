package viewcontrol;

import modellayer.Framework;
import common.Allergia;
import common.CsaladosUgyfel;
import common.Foglalas;
import common.Ugyfel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UjUgyfelBeviteleUI {
    private String megszolitas;
    private String keresztNev;
    private String vezetekNev;
    private String email;
    private String telefon;
    //private Foglalas foglalas;
    //private int utolsoSzamla;
    //private int osszesSzamla;
    //private Date utolsoLatogatas;

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
    private JComboBox telComboBox;
    private JTextField telefonTextfield;
    private JButton keszButton;

    private JPanel megszPanel;
    private JPanel vezPanel;

    public UjUgyfelBeviteleUI(Framework framework){

        this.framework = framework;
        ujUgyfel = new JFrame("Új ügyfél bevitele");
        ujUgyfelBevitelePanel=new JPanel();
        ujUgyfel.getContentPane();

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

        keszButton=new JButton("Ügyfél hozzáadása");
        keszButton.setBounds(350,600,280,40);

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
        ujUgyfelBevitelePanel.add(telComboBox);
        ujUgyfelBevitelePanel.add(telefonTextfield);
        ujUgyfelBevitelePanel.add(keszButton);

        ujUgyfel.add(ujUgyfelBevitelePanel);

        keszButton.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);



                framework.hozzaadUgyfel(saveUgyfel());
                JOptionPane.showMessageDialog(null, "Sikeres mentés!");

            }
        });

    }

    private Ugyfel saveUgyfel(){

        Ugyfel ugyfel = null;

        StringBuilder value=new StringBuilder();
        value.append(telComboBox.getSelectedItem().toString());
        value.append(telefonTextfield.getText());
        String telefon=value.toString();

        String megszolitasa=(String)jComboBox.getSelectedItem();

        ugyfel=new Ugyfel(megszolitasa,keresztNevTextfield.getText(),vezetekNevTextfield.getText(),
                emailTextfield.getText(),telefon);

        return ugyfel;
    }


    public JFrame getUjUgyfel() {

        return ujUgyfel;
    }

    private boolean ValidForm(){
        boolean valid=true;
        if(vezetekNevTextfield.getText().trim().isEmpty()||keresztNevTextfield.getText().trim().isEmpty()||
                telefonTextfield.getText().trim().isEmpty()|| emailTextfield.getText().trim().isEmpty()){
            valid=false;
            JOptionPane.showMessageDialog(null,"Minden mezőt ki kell tölteni!");
        }
        else {
            String telefon = telefonTextfield.getText();
            int num = 0;
            for (char c : telefon.toCharArray()) {
                if (Character.isDigit(c)) {
                    num += 1;
                } else {
                    valid = false;
                    JOptionPane.showMessageDialog(null, "Telefon formátuma nem megfelelő!");
                }
            }
            if (num != 7) {
                valid = false;
                JOptionPane.showMessageDialog(null, "Telefon formátuma nem megfelelő!");
            }
            String email = emailTextfield.getText();
            if (!email.contains("@") || !email.contains(".")) {
                valid = false;
                JOptionPane.showMessageDialog(null, "E-mail formátuma nem megfelelő!");
            }
        }
        return valid;
    }

    public void setUjUgyfel(JFrame ujUgyfel) {
        if (ValidForm()){
            StringBuilder value=new StringBuilder();
            value.append(telComboBox.getSelectedItem().toString());
            value.append(telefonTextfield.getText());
            String wholeTelefon=value.toString();

            megszolitas=jComboBox.getSelectedItem().toString();
            keresztNev=keresztNevTextfield.getText();
            vezetekNev=vezetekNevTextfield.getText();
            email=emailTextfield.getText();
            telefon=wholeTelefon;

            //Ugyfel ujugyfel=new Ugyfel(megszolitas,keresztNev,vezetekNev,email,telefon);
            this.ujUgyfel = ujUgyfel;
            JOptionPane.showMessageDialog(null, "Új ügyfél hozzáadva!");
        }
        else {
            JOptionPane.showMessageDialog(null, "Nincs helyesen kitöltve!");
        }
    }

    public JPanel getUjUgyfelBevitelePanel() {
        return ujUgyfelBevitelePanel;
    }

    public void setUjUgyfelBevitelePanel(JPanel ujUgyfelBevitelePanel) {
        this.ujUgyfelBevitelePanel = ujUgyfelBevitelePanel;
    }
}
