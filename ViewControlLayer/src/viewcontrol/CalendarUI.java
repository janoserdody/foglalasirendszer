package viewcontrol;

import modellayer.Framework;

import javax.swing.*;

public class CalendarUI {
    private JPanel calendarPanel;
    private JTable table1;
    private Framework framework;
    private JFrame calendar;

    public CalendarUI(Framework framework){
        this.framework = framework;

        calendar = new JFrame("Naptár");
    }

    public JFrame getCalendar() {
        return calendar;
    }

    public void setCalendar(JFrame calendar) {
        this.calendar = calendar;
    }

    public JPanel getCalendarPanel() {
        return calendarPanel;
    }

    public void setCalendarPanel(JPanel calendarPanel) {
        this.calendarPanel = calendarPanel;
    }
}
