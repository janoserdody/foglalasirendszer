package viewcontrol;

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

    // constructor
    public App(FoglalasUI foglalasNezet, UgyfelekUI ugyfelekNezet) {
        this.foglalasNezet = foglalasNezet;
        this.ugyfelekNezet = ugyfelekNezet;
        frame = new JFrame("App");
        frame.setContentPane(this.panelMain);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

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
                displayFoglalasBevitele();
            }
        });
    }

    private void setMainView() {
        Font f = new Font("sans-serif", Font.PLAIN, 20);
        UIManager.put("Menu.font", f);
        UIManager.put("MenuItem.font", f);
    }

    private void displayFoglalasBevitele() {
        foglalasNezet.foglalas.setContentPane(foglalasNezet.foglalasPanel);
        foglalasNezet.foglalas.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        foglalasNezet.foglalas.pack();
        foglalasNezet.foglalas.setVisible(true);
        foglalasNezet.foglalas.setSize(500,500);
    }

    private void displayUgyfelekListaja() {
        ugyfelekNezet.ugyfelekListaja.setContentPane(new UgyfelekUI().ugyfelekPane);
        ugyfelekNezet.ugyfelekListaja.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        ugyfelekNezet.ugyfelekListaja.pack();
        ugyfelekNezet.ugyfelekListaja.setVisible(true);
        ugyfelekNezet.ugyfelekListaja.setSize(500,500);
    }

    private JMenu getjMenu() {
        JMenu menu = new JMenu("Főmenü");
        menu.setSize(800,20);
        JMenuItem menuItemFoglalas = new JMenuItem("Foglalás bevitele");
        JMenuItem menuItemUgyelek = new JMenuItem("Ügyfelek listája");

        addMenuItemFoglalas(menuItemFoglalas);
        addMenuItemUgyfelek(menuItemUgyelek);

        menu.add(menuItemFoglalas);
        menu.add(menuItemUgyelek);
        return menu;
    }

    private void addMenuItemUgyfelek(JMenuItem menuItemUgyelek) {
        menuItemUgyelek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayUgyfelekListaja();
            }
        });
    }

    private  void addMenuItemFoglalas(JMenuItem menuItemFoglalas) {
        menuItemFoglalas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayFoglalasBevitele();
            }
        });
    }
}
