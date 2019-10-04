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
    private Framework framework;

    // constructor
    public App(FoglalasUI foglalasNezet, UgyfelekUI ugyfelekNezet, Framework framework) {
        this.foglalasNezet = foglalasNezet;
        this.ugyfelekNezet = ugyfelekNezet;
        this.framework = framework;
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
                displayFrame(foglalasNezet.getFoglalas(),
                        foglalasNezet.getFoglalasPanel());
            }
        });
    }

    private void setMainView() {
        Font f = new Font("sans-serif", Font.PLAIN, 20);
        UIManager.put("Menu.font", f);
        UIManager.put("MenuItem.font", f);
    }

    private void displayFrame(JFrame frame, JPanel panel) {
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1000,800);
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
                displayFrame(ugyfelekNezet.getUgyfelekListaja(),
                        ugyfelekNezet.getUgyfelekPane());
            }
        });
    }

    private  void addMenuItemFoglalas(JMenuItem menuItemFoglalas) {
        menuItemFoglalas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayFrame(foglalasNezet.getFoglalas(),
                        foglalasNezet.getFoglalasPanel());
            }
        });
    }
}
