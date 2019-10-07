package modellayer;

import common.Ugyfel;

import java.util.ArrayList;

public interface IFramework {
    void hozzaadUgyfel(Ugyfel ugyfel);

    void torolUgyfel(Ugyfel ugyfel);

    ArrayList<Ugyfel> getUgyfelLista();

    void setUgyfelLista(ArrayList<Ugyfel> ugyfelLista);

    String[] getUgyfelNevekListaja();

    boolean beolvasOsszesUgyfel();
}
