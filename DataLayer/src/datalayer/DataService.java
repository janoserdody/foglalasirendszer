package datalayer;

import common.Foglalas;
import common.Ugyfel;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class DataService implements IDataService {

    Database_and_Functions database = new Database_and_Functions();

    public boolean InsertUgyfel(Ugyfel ugyfel) {
        return false;
    }

    public Ugyfel GetUgyfel(int Id) {
        return null;
    }

    public Ugyfel GetUgyfel(String keresztNev, String vezetekNev) {
        return null;
    }

    public Ugyfel GetUgyfel(String telefon) {
        return null;
    }

    public boolean ModifyUgyfel(Ugyfel ugyfel) {
        return false;
    }

    public boolean RemoveUgyfel(int Id) {
        return false;
    }

    public ArrayList<Integer> ReadAllUgyfelId() {
        return new ArrayList<>();
    }

    public Foglalas GetFogalas(int Id) {
        return null;
    }

    public boolean RemoveFoglalas(int Id) {
        return false;
    }

    public ArrayList<Foglalas> ReadAllFoglalasForOneDay(LocalDateTime date) {
        return new ArrayList<>();
    }

    public boolean ModifyFoglalas(Foglalas foglalas) {
        return false;
    }

    public boolean InsertFoglalas(Foglalas foglalas) {
        return false;
    }
}
