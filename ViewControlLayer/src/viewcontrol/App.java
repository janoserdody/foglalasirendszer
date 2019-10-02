package viewcontrol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private JButton buttonMsg;
    private JPanel panelMain;

    public App() {
        AddButtonAction();

        SetMainView();
    }

    private void AddButtonAction() {
        buttonMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayFoglalasBevitele();
            }
        });
    }

    private void SetMainView() {
        Font f = new Font("sans-serif", Font.PLAIN, 20);
        UIManager.put("Menu.font", f);
        UIManager.put("MenuItem.font", f);
    }

    private static void DisplayFoglalasBevitele() {
        JFrame foglalas = new JFrame("Foglalás");
        foglalas.setContentPane(new Foglalas().foglalasPanel);
        foglalas.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        foglalas.pack();
        foglalas.setVisible(true);
        foglalas.setSize(500,500);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new App().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("Főmenü");
        menu.setSize(800,20);
        JMenuItem menuItemFoglalas = new JMenuItem("Foglalás bevitele");
        menuItemFoglalas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayFoglalasBevitele();
            }
        });

        menu.add(menuItemFoglalas);
        menubar.add(menu);

        frame.setJMenuBar(menubar);
        frame.setSize(1000,800);
    }
}
