package viewcontrol;

import modellayer.Framework;

import javax.swing.*;

public class FoglalasUI {

    private JLabel labelFoglalas;

    private JFrame foglalas;

    private JPanel foglalasPanel;

    private Framework framework;

    public FoglalasUI(Framework framework){

        this.framework = framework;

         foglalas = new JFrame("Foglalás");
    }

    public JFrame getFoglalas() {
        return foglalas;
    }

    public void setFoglalas(JFrame foglalas) {
        this.foglalas = foglalas;
    }

    public JPanel getFoglalasPanel() {
        return foglalasPanel;
    }

    public void setFoglalasPanel(JPanel foglalasPanel) {
        this.foglalasPanel = foglalasPanel;
    }
}
