package viewcontrol;

import modellayer.Framework;

import javax.swing.*;
import java.awt.*;

public class UgyfelekUI {

    private JPanel ugyfelekPane;
    private JList listUgyfelek;
    private JButton btnUgyfelAdatokMegynyitasa;
    private JFrame ugyfelekListaja;
    private Framework framework;
    private JScrollPane scrollPane;
    private JButton btnDelete;

    private JLabel title;

    public  UgyfelekUI(Framework framework){
        this.framework = framework;
        ugyfelekListaja = new JFrame("Ügyfelek listája");


        title=new JLabel("Ügyfél lista");
        title.setBounds(450,20,200,35);
        title.setFont(new Font("Arial",Font.BOLD,30));

        btnUgyfelAdatokMegynyitasa=new JButton("Ügyfél adatok megnyitása");
        btnUgyfelAdatokMegynyitasa.setBounds(250,700,200,30);

        btnDelete=new JButton("Ügyfél törlése");
        btnDelete.setBounds(500,700,200,30);


        listUgyfelek.setListData(framework.getUgyfelNevekListaja());
        listUgyfelek.setBounds(200,100,600,500);
        ugyfelekPane=new JPanel();
        ugyfelekPane.setLayout(null);


        ugyfelekPane.add(title);
        ugyfelekPane.add(listUgyfelek);
        ugyfelekPane.add(btnUgyfelAdatokMegynyitasa);
        ugyfelekPane.add(btnDelete);
    }

    public void UgyfelekInicializalas(){
        listUgyfelek.removeAll();
        listUgyfelek.setListData(framework.getUgyfelNevekListaja());
    }

    public JPanel getUgyfelekPane() {
        return ugyfelekPane;
    }

    public void setUgyfelekPane(JPanel ugyfelekPane) {
        this.ugyfelekPane = ugyfelekPane;
    }

    public JFrame getUgyfelekListaja() {
        return ugyfelekListaja;
    }

    public void setUgyfelekListaja(JFrame ugyfelekListaja) {
        this.ugyfelekListaja = ugyfelekListaja;
    }

}
