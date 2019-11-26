package viewcontrol;

import common.*;
import modellayer.Framework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

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
    private JLabel gyerekekSzamaLabel;
    private JComboBox gySzamaComboBox;
    private JLabel lblCegnev;
    private JTextField cegnevTextField;
    private JLabel lblSzamlaCim;
    private JTextField szamlacimTextfield;
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

        keszButton=new JButton("Ügyfél hozzáadása");
        keszButton.setBounds(400,650,280,40);

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
        ujUgyfelBevitelePanel.add(gyerekekSzamaLabel);
        ujUgyfelBevitelePanel.add(gySzamaComboBox);
        ujUgyfelBevitelePanel.add(lblCegnev);
        ujUgyfelBevitelePanel.add(cegnevTextField);
        ujUgyfelBevitelePanel.add(lblSzamlaCim);
        ujUgyfelBevitelePanel.add(szamlacimTextfield);
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


        StringBuilder value=new StringBuilder();
        value.append(telComboBox.getSelectedItem().toString());
        value.append(telefonTextfield.getText());
        String telefon=value.toString();

        String gyerSzama=(String)gySzamaComboBox.getSelectedItem();
        int gyerekekSzama = Integer.parseInt(gyerSzama);

        String megszolitasa=(String)jComboBox.getSelectedItem();

        String cegnev=cegnevTextField.getText();

        Ugyfel ugyfel = null;

        if (gyerekekSzama > 0){
            ugyfel = new CsaladosUgyfel(
                    megszolitasa,
                    keresztNevTextfield.getText(),
                    vezetekNevTextfield.getText(),
                    emailTextfield.getText(),
                    telefon,
                    gyerekekSzama);
        }
        else if(cegnev!=null){
            ugyfel=new CegesUgyfel(
                    megszolitasa,
                    keresztNevTextfield.getText(),
                    vezetekNevTextfield.getText(),
                    emailTextfield.getText(),
                    telefon,
                    cegnevTextField.getText(),
                    szamlacimTextfield.getText()
            );
        }
        else
        {
            ugyfel = new Ugyfel(megszolitasa,
                    keresztNevTextfield.getText(),
                    vezetekNevTextfield.getText(),
                    emailTextfield.getText(),
                    telefon
            );
        }

        ugyfel.setMegszolitas(megszolitasa);
        //ugyfel.setFoglalas(foglalas);
        ugyfel.setUtolsoLatogatas(LocalDate.now());


        ugyfel.setUtolsoLatogatas(LocalDate.now());

        return ugyfel;
    }

    public JFrame getUjUgyfel() {

        return ujUgyfel;
    }

    private Ugyfel saveUgyfel2(){
        Ugyfel ugyfel = null;

//        if (gyerekekSzama > 0){
//            ugyfel = new CsaladosUgyfel(
//                    megszolitasa,
//                    keresztNevTextfield.getText(),
//                    vezetekNevTextfield.getText(),
//                    emailTextfield.getText(),
//                    telefon,
//                    gyerekekSzama);
//        }
//        else
//        {
//            ugyfel = new Ugyfel(megszolitasa,
//                    keresztNevTextfield.getText(),
//                    vezetekNevTextfield.getText(),
//                    emailTextfield.getText(),
//                    telefon
//            );
//        }
//
//        ugyfel.setMegszolitas(megszolitasa);
//
//        ugyfel.setFoglalas(foglalas);

        ugyfel.setUtolsoLatogatas(LocalDate.now());

        return ugyfel;
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
