package viewcontrol;

import common.DateLabelFormatter;
import modellayer.Framework;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;

public class CalendarUI2 {
    private JDatePickerImpl datePickerFrom;
    private JDatePickerImpl datePickerTo;
    private Framework framework;
    private JPanel calendarPanel;
    private JFrame calendar;
    private JTable foglalasTabla;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String[] columnNames = { "Foglalás dátuma", "Ügyfél neve", "Telefonszám" };
    private DefaultTableModel model;
    JScrollPane sp;

    private String[][] data;

    public  CalendarUI2(Framework framework){
        this.framework = framework;
        calendarPanel = new JPanel();
        calendarPanel.setSize(1000,800);
        calendar = new JFrame("Naptár");
        calendar.setLayout(new FlowLayout());

        UtilDateModel modelFrom = new UtilDateModel();
        modelFrom.setDate(2019, 10, 25);
        modelFrom.setSelected(true);

        UtilDateModel modelTo = new UtilDateModel();
        modelTo.setDate(2019, 10, 25);
        modelTo.setSelected(true);

        Properties p = new Properties();
        p.put("text.today", "Ma");
        p.put("text.month", "Hónap");
        p.put("text.year", "Év");

        JDatePanelImpl datePanelFrom = new JDatePanelImpl(modelFrom, p);
        JDatePanelImpl datePanelTo = new JDatePanelImpl(modelTo, p);

        datePickerFrom = new JDatePickerImpl(datePanelFrom, new DateLabelFormatter());
        datePickerTo = new JDatePickerImpl(datePanelTo, new DateLabelFormatter());

        calendarPanel.add(new JLabel("Kérem adja meg a kezdő dátumot: "));
        calendarPanel.add(datePickerFrom);
        calendarPanel.add(new JLabel("Kérem adja meg a záró dátumot: "));
        calendarPanel.add(datePickerTo);

        JButton buttonTo = new JButton("OK");

        buttonTo.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                int rowCount = model.getRowCount();
                for (int i = rowCount - 1; i >= 0; i--) {
                    model.removeRow(i);
                }

                fromDate = convertToLocalDateViaInstant((Date) datePickerFrom.getModel().getValue());
                toDate = convertToLocalDateViaInstant((Date)datePickerTo.getModel().getValue());
                data = framework.getFoglalasokListaja(fromDate, toDate);

                addRowsToTable(model, data);
            }
        });

        calendarPanel.add(buttonTo);

        // Initializing the JTable
        fromDate = LocalDate.now().minusDays(30);
        toDate =  fromDate.plusDays(30);

        data = framework.getFoglalasokListaja(fromDate, toDate);

        foglalasTabla = new JTable(new DefaultTableModel(0, 3));

        model = (DefaultTableModel) foglalasTabla.getModel();
        model.setColumnIdentifiers(columnNames);

        addRowsToTable(model, data);

        foglalasTabla.setSize(700,400);
        sp = new JScrollPane(foglalasTabla);
        sp.setSize(700,400);
        calendarPanel.add(sp);
    }

    public JPanel getCalendarPanel() {
        return calendarPanel;
    }

    public void setCalendarPanel(JPanel calendarPanel) {
        this.calendarPanel = calendarPanel;
    }

    public JFrame getCalendar() {
        return calendar;
    }

    public void setCalendar(JFrame calendar) {
        this.calendar = calendar;
    }

    private LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    private void addRowsToTable(DefaultTableModel model, String[][] data){
        int size = data.length;
        for (int i = 0; i < size; i++)
        {
            model.addRow(data[i]);
        }
    }
}
