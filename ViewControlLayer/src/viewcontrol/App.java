package viewcontrol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private JButton buttonMsg;
    private JPanel panelMain;
    private static JFrame frame;

    // constructor
    public App() {
        addButtonAction();

        setMainView();
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

    private static void displayFoglalasBevitele() {
        JFrame foglalas = new JFrame("Foglalás");
        foglalas.setContentPane(new FoglalasUI().foglalasPanel);
        foglalas.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        foglalas.pack();
        foglalas.setVisible(true);
        foglalas.setSize(500,500);
    }

    private static void displayUgyfelekListaja() {
        JFrame ugyfelekListaja = new JFrame("Ügyfelek listája");
        ugyfelekListaja.setContentPane(new UgyfelekUI().ugyfelekPane);
        ugyfelekListaja.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        ugyfelekListaja.pack();
        ugyfelekListaja.setVisible(true);
        ugyfelekListaja.setSize(500,500);
    }

    public static void main(String[] args) {
        setMainWindow();

        JMenuBar menubar = new JMenuBar();
        JMenu menu = getjMenu();
        menubar.add(menu);


        frame.setJMenuBar(menubar);
        frame.setSize(1000,800);
    }

    private static JMenu getjMenu() {
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

    private static void addMenuItemUgyfelek(JMenuItem menuItemUgyelek) {
        menuItemUgyelek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayUgyfelekListaja();
            }
        });
    }

    private static void addMenuItemFoglalas(JMenuItem menuItemFoglalas) {
        menuItemFoglalas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayFoglalasBevitele();
            }
        });
    }

    private static void setMainWindow() {
        frame = new JFrame("App");
        frame.setContentPane(new App().panelMain);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
