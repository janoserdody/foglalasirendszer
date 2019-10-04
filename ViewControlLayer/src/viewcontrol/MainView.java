package viewcontrol;

import modellayer.Framework;

public class MainView {

    private FoglalasUI foglalasNezet;

    private UgyfelekUI ugyfelekNezet;

    private App fooldal;

    private Framework framework;

    public MainView(){

        framework = new Framework();

        foglalasNezet = new FoglalasUI(framework);

        ugyfelekNezet = new UgyfelekUI(framework);

        fooldal = new App(foglalasNezet, ugyfelekNezet, framework);
    }
}
