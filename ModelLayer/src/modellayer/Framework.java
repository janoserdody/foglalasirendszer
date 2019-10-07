package modellayer;

import common.Ugyfel;

import java.util.ArrayList;

public class Framework implements IFramework{

    private ArrayList<Ugyfel> ugyfelLista;

    public Framework(){
        ugyfelLista = new ArrayList<Ugyfel>();
        ugyfelLista.add(new Ugyfel("Kisasszony","Gabi", "Kis", "jhgfjhgf@freemail.hu", "1234567"));
        ugyfelLista.add(new Ugyfel("Úrhölgy","Julcsi", "Nagy", "uzuzt@freemail.hu", "9879654"));
    }

    public void hozzaadUgyfel(Ugyfel ugyfel){
        ugyfelLista.add(ugyfel);
    }

    public void torolUgyfel(Ugyfel ugyfel){
        ugyfelLista.remove(ugyfel);
    }

    public ArrayList<Ugyfel> getUgyfelLista() {
        return ugyfelLista;
    }
    
    public String[] getUgyfelNevekListaja(){
        
        String[] nevLista = new String[ugyfelLista.size()];

        int i = 0;

        for (Ugyfel ugyfel: ugyfelLista){
            nevLista[i] = ugyfel.getMegszolitas() + " " + ugyfel.getVezetekNev() + " " + ugyfel.getKeresztNev();
            i++;
        }

        return nevLista;
    }
 
    public void setUgyfelLista(ArrayList<Ugyfel> ugyfelLista) {
        this.ugyfelLista = ugyfelLista;
    }
}
