package viewcontrol;

import modellayer.Framework;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.*;

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
    private Framework framework;

    private JLabel title;
    private JLabel vezetekNevLabel;
    private JTextField vezetekNevTextfield;
    private JLabel keresztNevLabel;
    private JTextField keresztNevTextfield;
    private JLabel telefonLabel;
    private JTextField telefonTextfield;
    private JLabel szemelyekSzamaLabel;
    private JTextField szemelyekSzamaTextfield;
    private JLabel idopontLabel;
    private JTextField idopontTextfield;
    private JLabel etelAllergiaLabel;
    private JTextField etelAllergiaTextfield;
    private JLabel gyerekekSzamaLabel;
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

        telefonTextfield=new JTextField();
        telefonTextfield.setBounds(400,260,adatokSize.width,adatokSize.height);

        szemelyekSzamaLabel=new JLabel("Személyek száma:");
        szemelyekSzamaLabel.setBounds(30,310,adatokSize.width,adatokSize.height);
        szemelyekSzamaLabel.setFont(adatokFont);

        szemelyekSzamaTextfield=new JTextField();
        szemelyekSzamaTextfield.setBounds(400,310,adatokSize.width,adatokSize.height);

        idopontLabel=new JLabel("Időpont:");
        idopontLabel.setBounds(30,360,adatokSize.width,adatokSize.height);
        idopontLabel.setFont(adatokFont);

        idopontTextfield=new JTextField();
        idopontTextfield.setBounds(400,360,adatokSize.width,adatokSize.height);

        etelAllergiaLabel=new JLabel("Ételallergia:");
        etelAllergiaLabel.setBounds(30,410,adatokSize.width,adatokSize.height);
        etelAllergiaLabel.setFont(adatokFont);

        etelAllergiaTextfield=new JTextField();
        etelAllergiaTextfield.setBounds(400,410,adatokSize.width,adatokSize.height);

        gyerekekSzamaLabel=new JLabel("Gyerekek száma:");
        gyerekekSzamaLabel.setBounds(30,460,adatokSize.width,adatokSize.height);
        gyerekekSzamaLabel.setFont(adatokFont);

        gyerekekSzamaTextfield=new JTextField();
        gyerekekSzamaTextfield.setBounds(400,460,adatokSize.width,adatokSize.height);

        megjegyzesTextArea=new JTextArea("Megjegyzés...");
        megjegyzesTextArea.setBounds(400,510,adatokSize.width,100);

        elkuldButton=new JButton("Foglalás hozzáadása");
        elkuldButton.setBounds(350,660,280,40);

        foglalasPanel.add(title);
        foglalasPanel.add(vezetekNevLabel);
        foglalasPanel.add(vezetekNevTextfield);
        foglalasPanel.add(keresztNevLabel);
        foglalasPanel.add(keresztNevTextfield);
        foglalasPanel.add(telefonLabel);
        foglalasPanel.add(telefonTextfield);
        foglalasPanel.add(szemelyekSzamaLabel);
        foglalasPanel.add(szemelyekSzamaTextfield);
        foglalasPanel.add(idopontLabel);
        foglalasPanel.add(idopontTextfield);
        foglalasPanel.add(etelAllergiaLabel);
        foglalasPanel.add(etelAllergiaTextfield);
        foglalasPanel.add(gyerekekSzamaLabel);
        foglalasPanel.add(gyerekekSzamaTextfield);
        foglalasPanel.add(megjegyzesTextArea);
        foglalasPanel.add(elkuldButton);
    }



    public JFrame getFoglalas() {
        return foglalas;
    }

    public void setFoglalas(JFrame foglalas) {
        keresztNev=keresztNevTextfield.getText();
        vezetekNev=vezetekNevTextfield.getText();
        telefon=telefonTextfield.getText();
        szemelyekSzama=Integer.parseInt(szemelyekSzamaTextfield.getText());
        idopont=idopontTextfield.getText();
        etelAllergia=etelAllergiaTextfield.getText();
        gyerekekSzama=Integer.parseInt(gyerekekSzamaTextfield.getText());
        this.foglalas = foglalas;
    }

    public JPanel getFoglalasPanel() {
        return foglalasPanel;
    }

    public void setFoglalasPanel(JPanel foglalasPanel) {
        this.foglalasPanel = foglalasPanel;
    }
}
