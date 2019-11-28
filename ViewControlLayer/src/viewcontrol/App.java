package viewcontrol;

import modellayer.Framework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private JButton buttonMsg;
    private JPanel panelMain;
    private JFrame frame;
    private FoglalasUI foglalasNezet;
    private UgyfelekUI ugyfelekNezet;
    private CalendarUI2 calendarNezet;
    private UjUgyfelBeviteleUI ujUgyfelNezet;
    private UgyfelAdatModositasUI modositasNezet;
    private Framework framework;
    private ViewHelper viewHelper;

    // constructor
    public App(
            FoglalasUI foglalasNezet,
            UgyfelekUI ugyfelekNezet,
            CalendarUI2 calendarNezet,
            UjUgyfelBeviteleUI ujUgyfelNezet,
            UgyfelAdatModositasUI asztalokNezet,
            Framework framework) {
        this.foglalasNezet = foglalasNezet;
        this.ugyfelekNezet = ugyfelekNezet;
        this.calendarNezet = calendarNezet;
        this.ujUgyfelNezet = ujUgyfelNezet;
        this.modositasNezet = asztalokNezet;
        this.framework = framework;
        frame = new JFrame("App");
        frame.setContentPane(this.panelMain);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        viewHelper = new ViewHelper();

        addButtonAction();

        setMainView();

        JMenuBar menubar = new JMenuBar();
        JMenu menu = getjMenu();
        menubar.add(menu);

        frame.setJMenuBar(menubar);
        frame.setSize(1000,800);
    }

    private void addButtonAction() {
        buttonMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewHelper.displayFrame(foglalasNezet.getFoglalas(),
                        foglalasNezet.getFoglalasPanel());
            }
        });
    }

    private void setMainView() {
        Font f = new Font("sans-serif", Font.PLAIN, 20);
        UIManager.put("Menu.font", f);
        UIManager.put("MenuItem.font", f);
    }

    private JMenu getjMenu() {
        JMenu menu = new JMenu("Főmenü");
        menu.setSize(800,20);
        JMenuItem menuItemFoglalas = new JMenuItem("Foglalás bevitele");
        JMenuItem menuItemUgyelek = new JMenuItem("Ügyfelek listája");
        JMenuItem menuItemNaptar = new JMenuItem("Foglalási naptár");
        JMenuItem menuItemUjUgyfel = new JMenuItem("Új ügyfél bevitele");
        JMenuItem menuItemUgyfelAdatModositas = new JMenuItem("Ügyfél adat módosítás");

        addMenuItemFoglalas(menuItemFoglalas);
        addMenuItemUgyfelek(menuItemUgyelek);
        addMenuItemNaptar(menuItemNaptar);
        addMenuUjUgyfel(menuItemUjUgyfel);
        addMenuModositas(menuItemUgyfelAdatModositas);

        menu.add(menuItemFoglalas);
        menu.add(menuItemUgyelek);
        menu.add(menuItemNaptar);
        menu.add(menuItemUjUgyfel);
        menu.add(menuItemUgyfelAdatModositas);
        return menu;
    }

    private void addMenuItemUgyfelek(JMenuItem menuItemUgyfelek) {
        menuItemUgyfelek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ugyfelekNezet.ugyfelekInicializalas();
                viewHelper.displayFrame(ugyfelekNezet.getUgyfelekListaja(),
                        ugyfelekNezet.getUgyfelekPane());
            }
        });
    }

    private void addMenuItemNaptar(JMenuItem menuItemNaptar) {
        menuItemNaptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewHelper.displayFrame(calendarNezet.getCalendar(),
                        calendarNezet.getCalendarPanel());
            }
        });
    }

    private void addMenuUjUgyfel(JMenuItem menuItemUjUgyfel) {
        menuItemUjUgyfel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewHelper.displayFrame(ujUgyfelNezet.getUjUgyfel(),
                        ujUgyfelNezet.getUjUgyfelBevitelePanel());
            }
        });
    }

    private void addMenuModositas(JMenuItem menuItemAsztalok) {
        menuItemAsztalok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewHelper.displayFrame(modositasNezet.getModositas(),
                        modositasNezet.getModositasPanel());
            }
        });
    }

    private  void addMenuItemFoglalas(JMenuItem menuItemFoglalas) {
        menuItemFoglalas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewHelper.displayFrame(foglalasNezet.getFoglalas(),
                        foglalasNezet.getFoglalasPanel());
            }
        });
    }
}
