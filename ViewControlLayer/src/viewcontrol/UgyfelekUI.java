package viewcontrol;

import modellayer.Framework;

import javax.swing.*;
import java.awt.*;

public class UgyfelekUI {

    private JPanel ugyfelekPane;
    private JList listUgyfelek;
    private JFrame ugyfelekListaja;
    private Framework framework;

    private JLabel title;

    public  UgyfelekUI(Framework framework){
        this.framework = framework;
        ugyfelekListaja = new JFrame("Ügyfelek listája");
        /*ugyfelekPane=new JPanel();
        ugyfelekListaja.getContentPane();
        ugyfelekPane.setLayout(null);*/

        title=new JLabel("Ügyfél lista");
        title.setBounds(350,20,200,35);
        title.setFont(new Font("Arial",Font.BOLD,30));

        ugyfelekListaja.add(title);

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
