package viewcontrol;

import modellayer.Framework;

import javax.swing.*;

public class AsztalokUI {
    private Framework framework;
    private JFrame asztalok;
    private JPanel asztalokPanel;

    public AsztalokUI(Framework framework){
        this.framework = framework;
        asztalok = new JFrame("Asztalok");
    }

    public JFrame getAsztalok() {
        return asztalok;
    }

    public void setAsztalok(JFrame asztalok) {
        this.asztalok = asztalok;
    }

    public JPanel getAsztalokPanel() {
        return asztalokPanel;
    }

    public void setAsztalokPanel(JPanel asztalokPanel) {
        this.asztalokPanel = asztalokPanel;
    }
}
