package viewcontrol;

import modellayer.Framework;

import javax.swing.*;
import java.awt.*;

public class CalendarUI {
    private String id;
    private String nev;
    private String idopont;


    private JPanel calendarPanel;

    private Framework framework;
    private JFrame calendar;

    private JTable table1;


    private JLabel title;

    public CalendarUI(Framework framework){

        this.framework = framework;
        calendar = new JFrame("Naptár");

        calendar.setLayout(new FlowLayout());
        calendarPanel=new JPanel();
        calendar.getContentPane();
        calendarPanel.setLayout(null);

        title=new JLabel("Foglalás naptár");
        title.setBounds(350,20,300,35);
        title.setFont(new Font("Arial",Font.BOLD,30));

        String columnNames[]={"Hétfő","Kedd","Szerda","Csütörtök","Péntek","Szombat","Vasárnap"};

        Object data [][]={
                {"ID, Név, Időpont","ID, Név, Időpont","ID, Név, Időpont","ID, Név, Időpont","ID, Név, Időpont","ID, Név, Időpont","ID, Név, Időpont"},
                {"ID, Név, Időpont","ID, Név, Időpont","ID, Név, Időpont","ID, Név, Időpont","ID, Név, Időpont","ID, Név, Időpont","ID, Név, Időpont"},
                {"ID, Név, Időpont","ID, Név, Időpont","ID, Név, Időpont","ID, Név, Időpont","ID, Név, Időpont","ID, Név, Időpont","ID, Név, Időpont"}
        };

        table1=new JTable(data,columnNames);
        table1.setPreferredScrollableViewportSize(new Dimension(500,50));

        table1.setBounds(50,100,900,600);
        JScrollPane scrollPane=new JScrollPane(table1);
        calendar.add(scrollPane);

        table1.setVisible(true);

        calendarPanel.add(title);
        calendarPanel.add(table1);


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
