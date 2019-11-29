package viewcontrol;

import modellayer.Framework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UgyfelekUI {

    private JPanel ugyfelekPane;
    private JList listUgyfelek;
    private JButton btnUgyfelAdatokMegynyitasa;
    private JFrame ugyfelekListaja;
    private Framework framework;
    private UgyfelAdatModositasUI modositasNezet;
    private JScrollPane scrollPane;
    private JButton btnDelete;
    private JLabel title;
    private ListSelectionModel listSelectionModel;
    private ViewHelper viewHelper;
    private DefaultListModel model;

    public  UgyfelekUI(Framework framework, UgyfelAdatModositasUI modositasNezet){
        this.framework = framework;
        this.modositasNezet = modositasNezet;
        ugyfelekListaja = new JFrame("Ügyfelek listája");
        viewHelper = new ViewHelper();

        model = new DefaultListModel();

        title=new JLabel("Ügyfél lista");
        title.setBounds(450,20,200,35);
        title.setFont(new Font("Arial",Font.BOLD,30));

        btnUgyfelAdatokMegynyitasa=new JButton("Ügyfél adatok megnyitása");
        btnUgyfelAdatokMegynyitasa.setBounds(250,600,200,30);

        btnDelete=new JButton("Ügyfél törlése");
        btnDelete.setBounds(500,600,200,30);

        getUgyfelekToModel();

        listUgyfelek = new JList(model);

        listSelectionModel = listUgyfelek.getSelectionModel();

        listUgyfelek.setBounds(200,100,600,500);
        ugyfelekPane=new JPanel();
        ugyfelekPane.setLayout(null);

        JScrollPane listPane = new JScrollPane(listUgyfelek);
        listPane.setBounds(200,100,600,500);

        btnUgyfelAdatokMegynyitasa.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);

                int selectedIndex = listSelectionModel.getMinSelectionIndex();

                ArrayList<Integer> ugyfelIdLista = framework.GetUgyfelIdLista();

                modositasNezet.setUgyfelId(ugyfelIdLista.get(selectedIndex));

                viewHelper.displayFrame(modositasNezet.getModositas(),
                        modositasNezet.getModositasPanel());
            }
        });

        btnDelete.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);

                int selectedIndex = listSelectionModel.getMinSelectionIndex();

                ArrayList<Integer> ugyfelIdLista = framework.GetUgyfelIdLista();

                boolean sikeresTorles = framework.torolUgyfel(ugyfelIdLista.get(selectedIndex));

                model.remove(selectedIndex);

                if (sikeresTorles){
                    JOptionPane.showMessageDialog(null, "Sikeres törlés!");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Sikertelen törlés");
                }
            }
        });

        ugyfelekPane.add(title);
        ugyfelekPane.add(listPane);
        ugyfelekPane.add(btnUgyfelAdatokMegynyitasa);
        ugyfelekPane.add(btnDelete);
    }

    public void ugyfelekInicializalas(){
        if (listUgyfelek != null){
            model = (DefaultListModel) listUgyfelek.getModel();
            model.removeAllElements();
            getUgyfelekToModel();
            listUgyfelek.updateUI();
            ugyfelekPane.updateUI();
        }
    }

    private void getUgyfelekToModel(){
        String[] data = framework.getUgyfelNevekListaja();
        for (String item: data
        ) {
            model.addElement(item);
        }
    }

    public JPanel getUgyfelekPane() {
        return ugyfelekPane;
    }

    public void setUgyfelekPane(JPanel ugyfelekPane) {
        this.ugyfelekPane = ugyfelekPane;
    }

    public JFrame getUgyfelekListaja() {
        return ugyfelekListaja;
    }

    public void setUgyfelekListaja(JFrame ugyfelekListaja) {
        this.ugyfelekListaja = ugyfelekListaja;
    }
}
