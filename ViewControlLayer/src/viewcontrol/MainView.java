package viewcontrol;

import modellayer.Framework;

public class MainView {

    private FoglalasUI foglalasNezet;

    private UgyfelekUI ugyfelekNezet;

    private CalendarUI2 calendarNezet;

    private UgyfelAdatModositasUI asztalokNezet;

    private UjUgyfelBeviteleUI ujUgyfelNezet;

    private App fooldal;

    private Framework framework;

    public MainView(){

        framework = new Framework();

        foglalasNezet = new FoglalasUI(framework);

        ugyfelekNezet = new UgyfelekUI(framework);

        calendarNezet = new CalendarUI2(framework);

        ujUgyfelNezet = new UjUgyfelBeviteleUI(framework);

        asztalokNezet = new UgyfelAdatModositasUI(framework);

        fooldal = new App(
                foglalasNezet,
                ugyfelekNezet,
                calendarNezet,
                ujUgyfelNezet,
                asztalokNezet,
                framework);
    }
}
