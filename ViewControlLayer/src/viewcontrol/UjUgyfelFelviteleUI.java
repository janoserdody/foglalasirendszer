package viewcontrol;

import modellayer.Framework;

import javax.swing.*;

public class UjUgyfelFelviteleUI {

    private JLabel labelUjUgyfelFelvitele;

    private JFrame UjUgyfelFelvitele;

    private JPanel UjUgyfelFelvitelePanel;

    private Framework framework;

    public UjUgyfelFelviteleUI(Framework framework){

        this.framework = framework;

        UjUgyfelFelvitele = new JFrame("Új Ügyfél felvitele");
    }

    public JFrame setUjUgyfel(){return UjUgyfelFelvitele;}
    public JPanel getUjUgyfelFelvitelePanel(){return UjUgyfelFelvitelePanel;}
}
