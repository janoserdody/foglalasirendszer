package viewcontrol;

public class MainView {

    private FoglalasUI foglalasNezet;

    private UgyfelekUI ugyfelekNezet;

    private App fooldal;

    public MainView(){
        foglalasNezet = new FoglalasUI();

        ugyfelekNezet = new UgyfelekUI();

        fooldal = new App(foglalasNezet, ugyfelekNezet);
    }

}
