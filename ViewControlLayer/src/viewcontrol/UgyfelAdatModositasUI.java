package viewcontrol;

import common.CegesUgyfel;
import common.CsaladosUgyfel;
import common.Ugyfel;
import modellayer.Framework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UgyfelAdatModositasUI {

    private Framework framework;
    private JFrame modositas;
    private JPanel modositasPanel;

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
    private int ugyfelId;
    private Ugyfel ugyfel;

    public UgyfelAdatModositasUI(Framework framework){
        this.framework = framework;
        modositas = new JFrame("Ügyfél adatok módosítása");
        modositasPanel =new JPanel();
        modositas.getContentPane();
        modositasPanel.setLayout(null);

        String[] kodArray={"A2","A4","A5","A6","A7","A8"};

        Font iFont=new Font("Arial",Font.ITALIC,20);

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

        btnAdatokModositasa.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);

                boolean sikeresModositas = false;

               if (ugyfel != null){
                   sikeresModositas = framework.modositUgyfel(ugyfel);
               }
                if (sikeresModositas){
                    JOptionPane.showMessageDialog(null, "Sikeres módosítás!");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Sikertelen módosítás");
                }
            }
        });

        modositasPanel.add(title);
        modositasPanel.add(title);
        modositasPanel.add(megszolitasLabel);
        modositasPanel.add(jComboBox);
        modositasPanel.add(vezetekNevLabel);
        modositasPanel.add(vezetekNevTextfield);
        modositasPanel.add(keresztNevLabel);
        modositasPanel.add(keresztNevTextfield);
        modositasPanel.add(emailLabel);
        modositasPanel.add(emailTextfield);
        modositasPanel.add(telefonLabel);
        modositasPanel.add(telComboBox);
        modositasPanel.add(telefonTextfield);
        modositasPanel.add(gyerekekSzamaLabel);
        modositasPanel.add(gySzamaComboBox);
        modositasPanel.add(lblCegnev);
        modositasPanel.add(cegnevTextField);
        modositasPanel.add(lblSzamlaCim);
        modositasPanel.add(szamlacimTextfield);
        modositasPanel.add(btnAdatokModositasa);
    }

    public JFrame getModositas() {
        return modositas;
    }

    public void setModositas(JFrame modositas) {
        this.modositas = modositas;
    }

    public JPanel getModositasPanel() {
        return modositasPanel;
    }

    public void setModositasPanel(JPanel modositasPanel) {
        this.modositasPanel = modositasPanel;
    }

    public int getUgyfelId() {
        return ugyfelId;
    }

    public void setUgyfelId(int ugyfelId) {
        this.ugyfelId = ugyfelId;
        ugyfel = framework.GetUgyfel(ugyfelId);

        jComboBox.setSelectedIndex(getIndexMegszolitas(ugyfel.getMegszolitas()));

        vezetekNevTextfield.setText(ugyfel.getVezetekNev());

        keresztNevTextfield.setText(ugyfel.getKeresztNev());

        emailTextfield.setText(ugyfel.getEmail());

        telefonTextfield.setText(ugyfel.getTelefon());

        telComboBox.setSelectedIndex(getIndexTelefon(ugyfel.getTelefon()));

        if (ugyfel instanceof CsaladosUgyfel){
            gySzamaComboBox.setSelectedIndex(((CsaladosUgyfel)ugyfel).getGyerekekSzama());
        }

        if (ugyfel instanceof CegesUgyfel){
            szamlacimTextfield.setText(((CegesUgyfel)ugyfel).getSzamlazasiCim());
            cegnevTextField.setText(((CegesUgyfel)ugyfel).getCegNev());
        }
    }

    private int getIndexMegszolitas(String megszolitas){
        if (megszolitas == null || megszolitas.isEmpty())
        {
            return 0;
        }
        int index = 0;
        switch (megszolitas){
            case "id": index = 0;
            break;
            case  "ifj": index = 1;
            break;
            case  "dr": index = 2;
            break;
            default: index = 0;
            break;
        }
        return index;
    }

    private  int getIndexTelefon(String telefon){
        if (telefon.length() < 2)
        {
            return 0;
        }

        String firstTwo = telefon.substring(0,2);
        int index = 0;
        switch (firstTwo){
            case "20": index = 0;
            break;
            case  "30": index = 1;
            break;
            case "70": index = 2;
            break;
            default: index = 0;
            break;
        }
        return index;
    }
}
