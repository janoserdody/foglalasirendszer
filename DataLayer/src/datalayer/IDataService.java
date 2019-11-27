package datalayer;

import common.Foglalas;
import common.Ugyfel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface IDataService {
    //  beszúr egy ügyfelet az adatbázisba
    boolean insertUgyfel(Ugyfel ugyfel);

    // Beolvassa egy ügyfél adatait az adatbázisból
    Ugyfel getUgyfel(int Id);

    Ugyfel getUgyfel(String keresztNev, String vezetekNev);

    Ugyfel getUgyfel(String telefon);

    // Módosítja egy ügyfél adatait
    boolean modifyUgyfel(Ugyfel ugyfel);

    // Töröl egy ügyfelet az adatbázisból
    boolean removeUgyfel(int Id);

    // Beolvassa egy tömbbe az összes ügyfél ID-ét
    ArrayList<Integer> readAllUgyfelId();

    // Beszúrja egy foglalás adatait az adatbázisba
    boolean insertFoglalas(Foglalas foglalas);

    // Beolvassa egy foglalás adatait az adatbázisból
    Foglalas getFogalas(int Id);

    // Módosítja egy foglalás adatait
    boolean modifyFoglalas(Foglalas foglalas);

    // Töröl egy foglalást az adatbázisból
    boolean removeFoglalas(int Id);

    // Beolvassa egy adott napra eső összes foglalás Id-eit
    List<Foglalas> readAllFoglalasForOneDay(LocalDate date);
}
