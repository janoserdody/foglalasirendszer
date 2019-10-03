package modellayer;

import java.util.ArrayList;

public class Framework {

    private ArrayList<Ugyfel> ugyfelLista = new ArrayList<Ugyfel>();

    public Framework(){

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

    public void setUgyfelLista(ArrayList<Ugyfel> ugyfelLista) {
        this.ugyfelLista = ugyfelLista;
    }
}
