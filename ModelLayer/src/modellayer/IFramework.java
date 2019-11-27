package modellayer;

import common.Foglalas;
import common.Ugyfel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public interface IFramework {
    void hozzaadUgyfel(Ugyfel ugyfel);

    void torolUgyfel(Ugyfel ugyfel);

    ArrayList<Ugyfel> getUgyfelLista();

    void setUgyfelLista(ArrayList<Ugyfel> ugyfelLista);

    String[] getUgyfelNevekListaja();

    boolean beolvasOsszesUgyfelId();

    ArrayList<Integer> beolvasEgyNapFoglalasok(LocalDateTime date);

    ArrayList<Foglalas> beolvasIntervallumFoglalasok(LocalDateTime fromDate, LocalDateTime toDate);

    public String[][] getFoglalasokListaja(LocalDate fromDate, LocalDate toDate);
}
