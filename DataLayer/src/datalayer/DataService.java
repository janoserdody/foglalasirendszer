package datalayer;

import common.Foglalas;
import common.Ugyfel;

import java.util.ArrayList;
import java.util.Date;

public class DataService implements IDataService {

    public boolean InsertUgyfel(Ugyfel ugyfel) {
        return false;
    }

    public Ugyfel GetUgyfel(int Id) {
        return null;
    }

    public boolean ModifyUgyfel(Ugyfel ugyfel) {
        return false;
    }

    public boolean RemoveUgyfel(int Id) {
        return false;
    }

    public ArrayList<Integer> ReadAllUgyfelId() {
        return new ArrayList<Integer>();
    }

    public Foglalas GetFogalas(int Id) {
        return null;
    }

    public boolean RemoveFoglalas(int Id) {
        return false;
    }

    public ArrayList<Integer> ReadAllFoglalsForOneDay(Date date) {
        return new ArrayList<Integer>();
    }

    public boolean ModifyFoglalas(Foglalas foglalas) {
        return false;
    }

    public boolean InsertFoglalas(Foglalas foglalas) {
        return false;
    }
}
