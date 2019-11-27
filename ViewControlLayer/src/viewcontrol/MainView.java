package viewcontrol;

import modellayer.Framework;

public class MainView {

    private FoglalasUI foglalasNezet;

    private UgyfelekUI ugyfelekNezet;

    private CalendarUI2 calendarNezet;

    private UgyfelAdatModositasUI modositasNezet;

    private UjUgyfelBeviteleUI ujUgyfelNezet;

    private App fooldal;

    private Framework framework;

    public MainView(){

        framework = new Framework();

        modositasNezet = new UgyfelAdatModositasUI(framework);

        foglalasNezet = new FoglalasUI(framework);

        ugyfelekNezet = new UgyfelekUI(framework, modositasNezet);

        calendarNezet = new CalendarUI2(framework);

        ujUgyfelNezet = new UjUgyfelBeviteleUI(framework);

        fooldal = new App(
                foglalasNezet,
                ugyfelekNezet,
                calendarNezet,
                ujUgyfelNezet,
                modositasNezet,
                framework);
    }
}
