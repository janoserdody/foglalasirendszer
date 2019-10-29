package datalayer;

import common.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class DataService implements IDataService {

    private Database_and_Functions database;

    private LocalTimeZone localTimeZone;


    public DataService(LocalTimeZone localTimeZone){
        this.localTimeZone = localTimeZone;
         database = new Database_and_Functions(localTimeZone);
    }

    public boolean InsertUgyfel(Ugyfel ugyfel) {

        boolean insertWasSuccessfull = false;
        int id = 0;
        int gyerekSzam = 0;
        String cegNev = null;
        String szamlazasiCim = null;
        UgyfelTipus ugyfelTipus;
        if(ugyfel instanceof CsaladosUgyfel) {
            ugyfelTipus = UgyfelTipus.CsaladosUgyfel;
            CsaladosUgyfel csaladosUgyfel = (CsaladosUgyfel)ugyfel;
            gyerekSzam = csaladosUgyfel.getGyerekekSzama();

        }
        else if(ugyfel instanceof CegesUgyfel) {
            ugyfelTipus = UgyfelTipus.CegesUgyfel;
            CegesUgyfel cegesUgyfel = (CegesUgyfel)ugyfel;
            cegNev = cegesUgyfel.getCegNev();
            szamlazasiCim = cegesUgyfel.getSzamlazasiCim();
        }
        else {
            ugyfelTipus = UgyfelTipus.Ugyfel;
            id = database.insertUgyfel(
                    ugyfelTipus,
                    ugyfel.getMegszolitas(),
                    ugyfel.getKeresztNev(),
                    ugyfel.getVezetekNev(),
                    ugyfel.getEmail(),
                    ugyfel.getTelefon(),
                    ugyfel.getUtolsoSzamla(),
                    ugyfel.getOsszesSzamla(),
                    ugyfel.getUtolsoLatogatas(),
                    cegNev,
                    szamlazasiCim,
                    gyerekSzam);
            if (id > 0) {
                ugyfel.setId(id);
                insertWasSuccessfull = true;
            }
        }
            return insertWasSuccessfull;
    }

    public Ugyfel GetUgyfel(int Id) {
        database.Ugyfel_Lekerdezes_Funkcio(Id);
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
        database.deleteUgyfel(Id);
        return false;
    }

    public ArrayList<Integer> ReadAllUgyfelId() {
        return new ArrayList<>();
    }

    public Foglalas GetFogalas(int Id) {
        database.foglalas_Lekerdezes_Funkcio(Id);
        return null;
    }

    public boolean RemoveFoglalas(int Id) {
        database.deleteFoglalas(Id);
        return false;
    }

    public ArrayList<Foglalas> ReadAllFoglalasForOneDay(LocalDateTime date) {
        return new ArrayList<>();
    }

    //Itt nem tudom miért nem fogadja el a get-ket?
    // Azért nem, mert LocalDateTime típus a foglalás időpontja, és nem java.sql.Date
    public boolean ModifyFoglalas(Foglalas foglalas) {
        FoglalasTipus foglalasTipus;
        foglalasTipus = FoglalasTipus.Foglalas;
        database.updateFoglalas(
                foglalas.getId(),
                foglalas.getDatum(),
                foglalas.getSzemelyekSzama(),
                foglalas.getEtelallergia(),
                foglalas.getGyerekekSzama(),
                foglalas.getMegjegyzes());

        return false;
    }

    public boolean InsertFoglalas(Foglalas foglalas) {

        boolean insertWasSuccessfull = false;
        int id = 0;

        FoglalasTipus foglalasTipus = FoglalasTipus.Foglalas;
        id = database.insertFoglalas(
                foglalasTipus,
                foglalas.getDatum(),
                foglalas.getSzemelyekSzama(),
                foglalas.getEtelallergia(),
                foglalas.getGyerekekSzama(),
                foglalas.getMegjegyzes());
        if (id > 0) {
            foglalas.setId(id);
            insertWasSuccessfull = true;
        }
        return insertWasSuccessfull;
    }
}
