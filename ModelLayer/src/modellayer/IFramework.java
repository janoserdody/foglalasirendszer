package modellayer;

import common.Foglalas;
import common.Ugyfel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public interface IFramework {
    void hozzaadUgyfel(Ugyfel ugyfel);

    boolean modositUgyfel(Ugyfel ugyfel);

    boolean torolUgyfel(Ugyfel ugyfel);

    boolean torolUgyfel(int id);

    ArrayList<Ugyfel> getUgyfelLista();

    void setUgyfelLista(ArrayList<Ugyfel> ugyfelLista);

    String[] getUgyfelNevekListaja();

    boolean beolvasOsszesUgyfelId();

    String[][] getFoglalasokListaja(LocalDate fromDate, LocalDate toDate);

    ArrayList<Integer> GetUgyfelIdLista();

    Ugyfel GetUgyfel(int id);
}
