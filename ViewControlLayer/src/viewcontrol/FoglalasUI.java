package viewcontrol;

import common.Allergia;
import common.CsaladosUgyfel;
import common.Foglalas;
import common.Ugyfel;
import modellayer.Framework;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.awt.event.*;
import java.time.format.DateTimeFormatter;

public class FoglalasUI {

    private String keresztNev;
    private String vezetekNev;
    private String telefon;
    private int szemelyekSzama;
    private String idopont;
    private String etelAllergia;
    private int gyerekekSzama;

    private JLabel labelFoglalas;
    private JFrame foglalas;
    private JPanel foglalasPanel;
    private JButton elkuld2;
    private Framework framework;

    private JLabel title;
    private JLabel megszolitasLabel;
    private JComboBox jComboBox;
    private JLabel vezetekNevLabel;
    private JTextField vezetekNevTextfield;
    private JLabel keresztNevLabel;
    private JTextField keresztNevTextfield;
    private JLabel telefonLabel;
    private JComboBox telComboBox;
    private JTextField telefonTextfield;
    private JLabel emailLabel;
    private JTextField emailTextfield;
    private JLabel szemelyekSzamaLabel;
    private JComboBox szemSzamComboBox;
    private JTextField szemelyekSzamaTextfield;
    private JLabel idopontLabel;
    private JTextField idopontTextfield;
    private JLabel etelAllergiaLabel;
    private JComboBox allComboBox;
    private JTextField etelAllergiaTextfield;
    private JLabel gyerekekSzamaLabel;
    private JComboBox gySzamaComboBox;
    private JTextField gyerekekSzamaTextfield;
    private JTextArea megjegyzesTextArea;
    private JButton elkuldButton;

    public FoglalasUI(Framework framework){

        this.framework = framework;
         foglalas = new JFrame("Foglalás");
         foglalasPanel=new JPanel();
         foglalas.getContentPane();
         foglalasPanel.setLayout(null);

        Font adatokFont=new Font("Arial",Font.BOLD,20);

        Dimension cimSize=new Dimension();
        cimSize.setSize(400,35);
        Dimension adatokSize=new Dimension();
        adatokSize.setSize(350,25);

        title=new JLabel("Foglalás bevitele");
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

        telefonLabel=new JLabel("Telefon:");
        telefonLabel.setBounds(30,260,adatokSize.width,adatokSize.height);
        telefonLabel.setFont(adatokFont);

        telComboBox=new JComboBox();
        telComboBox.addItem("20");
        telComboBox.addItem("30");
        telComboBox.addItem("70");
        telComboBox.setBounds(400,260,100,25);


        telefonTextfield=new JTextField();
        telefonTextfield.setBounds(520,260,230,adatokSize.height);

        emailLabel=new JLabel("Email:");
        emailLabel.setBounds(30,310,adatokSize.width,adatokSize.height);
        emailLabel.setFont(adatokFont);

        emailTextfield=new JTextField();
        emailTextfield.setBounds(400,310,adatokSize.width,adatokSize.height);

        szemelyekSzamaLabel=new JLabel("Személyek száma:");
        szemelyekSzamaLabel.setBounds(30,360,adatokSize.width,adatokSize.height);
        szemelyekSzamaLabel.setFont(adatokFont);

        szemSzamComboBox=new JComboBox();
        szemSzamComboBox.addItem("1");
        szemSzamComboBox.addItem("2");
        szemSzamComboBox.addItem("3");
        szemSzamComboBox.addItem("4");
        szemSzamComboBox.addItem("5");
        szemSzamComboBox.addItem("6");
        szemSzamComboBox.addItem("7");
        szemSzamComboBox.addItem("8");
        szemSzamComboBox.setBounds(400,360,100,25);

        idopontLabel=new JLabel("Időpont:");
        idopontLabel.setBounds(30,410,adatokSize.width,adatokSize.height);
        idopontLabel.setFont(adatokFont);

        idopontTextfield=new JTextField();
        idopontTextfield.setText("YYYY-MM-DD HH:MM");
        idopontTextfield.setBounds(400,410,350,adatokSize.height);

        etelAllergiaLabel=new JLabel("Ételallergia:");
        etelAllergiaLabel.setBounds(30,460,adatokSize.width,adatokSize.height);
        etelAllergiaLabel.setFont(adatokFont);

        allComboBox=new JComboBox();
        allComboBox.addItem("Gluten");
        allComboBox.addItem("Tej");
        allComboBox.addItem("Mogyoro");
        allComboBox.addItem("Hisztamin");
        allComboBox.addItem("Laktoz");
        allComboBox.addItem("Kazein");
        allComboBox.addItem("Nincs");
        allComboBox.setBounds(400,460,100,adatokSize.height);



        etelAllergiaTextfield=new JTextField();
        etelAllergiaTextfield.setBounds(400,460,adatokSize.width,adatokSize.height);

        gyerekekSzamaLabel=new JLabel("Gyerekek száma:");
        gyerekekSzamaLabel.setBounds(30,510,adatokSize.width,adatokSize.height);
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
        gySzamaComboBox.setBounds(400,510,100,25);


        megjegyzesTextArea=new JTextArea("Megjegyzés...");
        megjegyzesTextArea.setBounds(400,560,adatokSize.width,70);

        elkuldButton=new JButton("Foglalás hozzáadása");
        elkuldButton.setBounds(350,660,280,40);

        foglalasPanel.add(title);
        foglalasPanel.add(vezetekNevLabel);
        foglalasPanel.add(megszolitasLabel);
        foglalasPanel.add(jComboBox);
        foglalasPanel.add(vezetekNevTextfield);
        foglalasPanel.add(keresztNevLabel);
        foglalasPanel.add(keresztNevTextfield);
        foglalasPanel.add(telefonLabel);
        foglalasPanel.add(telComboBox);
        foglalasPanel.add(telefonTextfield);
        foglalasPanel.add(szemelyekSzamaLabel);
        foglalasPanel.add(szemSzamComboBox);
        foglalasPanel.add(idopontLabel);
        foglalasPanel.add(idopontTextfield);
        foglalasPanel.add(etelAllergiaLabel);
        foglalasPanel.add(allComboBox);
        foglalasPanel.add(gyerekekSzamaLabel);
        foglalasPanel.add(gySzamaComboBox);
        foglalasPanel.add(megjegyzesTextArea);
        foglalasPanel.add(elkuldButton);
        foglalasPanel.add(emailLabel);
        foglalasPanel.add(emailTextfield);


        elkuldButton.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if(ValidFoglalas()){
                    Foglalas foglalas = saveFoglalas();

                    framework.hozzaadUgyfel(saveUgyfel(foglalas));

                }
                else {
                    JOptionPane.showMessageDialog(null, "Nincs helyesen kitöltve!");
                }
            }
        });
    }

    private boolean ValidFoglalas(){
        boolean valid=true;
        if(vezetekNevTextfield.getText().trim().isEmpty()||keresztNevTextfield.getText().trim().isEmpty()||telefonTextfield.getText().trim().isEmpty()||
                idopontTextfield.getText().trim().isEmpty()||emailTextfield.getText().trim().isEmpty()){
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



    public JFrame getFoglalas() {
        return foglalas;
    }

    public void setFoglalas(JFrame foglalas) {

        this.foglalas = foglalas;
    }

    private Foglalas saveFoglalas(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        LocalDateTime dateTime = LocalDateTime.parse(idopontTextfield.getText(), formatter);
        String megszolitas=(String)jComboBox.getSelectedItem();
        String szemSzama=(String)szemSzamComboBox.getSelectedItem();
        int szemSzamaInt=Integer.parseInt(szemSzama);

        Foglalas foglalas = new Foglalas(dateTime, szemSzamaInt);
        String megszolitasa=(String) jComboBox.getSelectedItem();
        foglalas.setMegszolitas(megszolitasa);
        foglalas.setEtelallergia(Allergia.valueOf(allComboBox.getSelectedItem().toString()));

        foglalas.setMegjegyzes(megjegyzesTextArea.getText());

        String gyerSzama=(String)gySzamaComboBox.getSelectedItem();
        int gyerSzamaInt=Integer.parseInt(gyerSzama);
        foglalas.setGyerekekSzama(gyerSzamaInt);

        return foglalas;
    }

    private Ugyfel saveUgyfel(Foglalas foglalas){

        StringBuilder value=new StringBuilder();
        value.append(telComboBox.getSelectedItem().toString());
        value.append(telefonTextfield.getText());
        String telefon=value.toString();

        String gyerSzama=(String)gySzamaComboBox.getSelectedItem();
        gyerekekSzama = Integer.parseInt(gyerSzama);

        Ugyfel ugyfel = null;

        if (gyerekekSzama > 0){
            ugyfel = new CsaladosUgyfel(
                    "MR.",
                    keresztNevTextfield.getText(),
                    vezetekNevTextfield.getText(),
                    emailTextfield.getText(),
                    telefon,
                    gyerekekSzama);
        }
        else
        {
            ugyfel = new Ugyfel("MR.",
                    keresztNevTextfield.getText(),
                    vezetekNevTextfield.getText(),
                    emailTextfield.getText(),
                    telefon
            );
        }

        ugyfel.setFoglalas(foglalas);

        ugyfel.setUtolsoLatogatas(LocalDate.now());

        return ugyfel;
    }

    public JPanel getFoglalasPanel() {
        return foglalasPanel;
    }

    public void setFoglalasPanel(JPanel foglalasPanel) {
        this.foglalasPanel = foglalasPanel;
    }
}
