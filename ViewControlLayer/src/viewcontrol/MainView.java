package viewcontrol;

import modellayer.Framework;

public class MainView {

    private FoglalasUI foglalasNezet;

    private UgyfelekUI ugyfelekNezet;

    private CalendarUI calendarNezet;

    private UjUgyfelBeviteleUI ujUgyfelNezet;

    private App fooldal;

    private Framework framework;

    public MainView(){

        framework = new Framework();

        foglalasNezet = new FoglalasUI(framework);

        ugyfelekNezet = new UgyfelekUI(framework);

        calendarNezet = new CalendarUI(framework);

        ujUgyfelNezet = new UjUgyfelBeviteleUI(framework);

        fooldal = new App(
                foglalasNezet,
                ugyfelekNezet,
                calendarNezet,
                ujUgyfelNezet,
                framework);
    }
}
