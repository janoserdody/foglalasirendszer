package viewcontrol;

import modellayer.Framework;

import javax.swing.*;

public class UjUgyfelBeviteleUI {
    private Framework framework;
    private JFrame ujUgyfel;
    private JPanel ujUgyfelBevitelePanel;

    public UjUgyfelBeviteleUI(Framework framework){

        this.framework = framework;
        ujUgyfel = new JFrame("Új ügyfél bevitele");

    }

    public JFrame getUjUgyfel() {
        return ujUgyfel;
    }

    public void setUjUgyfel(JFrame ujUgyfel) {
        this.ujUgyfel = ujUgyfel;
    }

    public JPanel getUjUgyfelBevitelePanel() {
        return ujUgyfelBevitelePanel;
    }

    public void setUjUgyfelBevitelePanel(JPanel ujUgyfelBevitelePanel) {
        this.ujUgyfelBevitelePanel = ujUgyfelBevitelePanel;
    }
}
