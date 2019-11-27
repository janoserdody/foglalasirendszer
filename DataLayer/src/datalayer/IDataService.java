package datalayer;

import common.Foglalas;
import common.Ugyfel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface IDataService {
    //  beszúr egy ügyfelet az adatbázisba
    boolean InsertUgyfel(Ugyfel ugyfel);

    // Beolvassa egy ügyfél adatait az adatbázisból
    Ugyfel GetUgyfel(int Id);

    Ugyfel GetUgyfel(String keresztNev, String vezetekNev);

    Ugyfel GetUgyfel(String telefon);

    // Módosítja egy ügyfél adatait
    boolean ModifyUgyfel(Ugyfel ugyfel);

    // Töröl egy ügyfelet az adatbázisból
    boolean RemoveUgyfel(int Id);

    // Beolvassa egy tömbbe az összes ügyfél ID-ét
    ArrayList<Integer> ReadAllUgyfelId();

    // Beszúrja egy foglalás adatait az adatbázisba
    boolean InsertFoglalas(Foglalas foglalas);

    // Beolvassa egy foglalás adatait az adatbázisból
    Foglalas GetFogalas(int Id);

    // Módosítja egy foglalás adatait
    boolean ModifyFoglalas(Foglalas foglalas);

    // Töröl egy foglalást az adatbázisból
    boolean RemoveFoglalas(int Id);

    // Beolvassa egy adott napra eső összes foglalás Id-eit
    List<Foglalas> ReadAllFoglalasForOneDay(LocalDate date);
}
