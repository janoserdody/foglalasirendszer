package viewcontrol;

import modellayer.Framework;

import javax.swing.*;

public class UgyfelekUI {

    private JPanel ugyfelekPane;

    private JList listUgyfelek;

    private JFrame ugyfelekListaja;

    private Framework framework;

    public  UgyfelekUI(Framework framework){

        this.framework = framework;

        ugyfelekListaja = new JFrame("Ügyfelek listája");

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
