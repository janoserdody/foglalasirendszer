package datalayer;

import common.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
            gyerekSzam = ((CsaladosUgyfel)ugyfel).getGyerekekSzama();

        }
        else if(ugyfel instanceof CegesUgyfel) {
            ugyfelTipus = UgyfelTipus.CegesUgyfel;
            CegesUgyfel cegesUgyfel = (CegesUgyfel)ugyfel;
            cegNev = cegesUgyfel.getCegNev();
            szamlazasiCim = cegesUgyfel.getSzamlazasiCim();
        }
        else {
            ugyfelTipus = UgyfelTipus.Ugyfel;
        }
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
            return insertWasSuccessfull;
    }

    public Ugyfel GetUgyfel(int Id) {
        return database.Ugyfel_Lekerdezes_Funkcio(Id);
    }

    public Ugyfel GetUgyfel(String keresztNev, String vezetekNev) {
        return database.Ugyfel_Lekerdezes_Funkcio_Keresztnev_Vezeteknev(keresztNev, vezetekNev);
    }

    public Ugyfel GetUgyfel(String telefon) {
        return database.Ugyfel_Lekerdezes_Funkcio_Telefonszam(telefon);
    }

    public boolean ModifyUgyfel(Ugyfel ugyfel) {
        boolean insertWasSuccessfull = false;
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
        }

        insertWasSuccessfull = database.ModifyUgyfel(
                ugyfel.getId(),
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

        return insertWasSuccessfull;
    }

    public boolean RemoveUgyfel(int Id) {
        database.deleteUgyfel(Id);
        return false;
    }

    public ArrayList<Integer> ReadAllUgyfelId() {
        return database.Ugyfel_Lekerdezes_Funkcio_UgyfelID();
    }

    public Foglalas GetFogalas(int Id) {
        return (Foglalas) database.foglalas_Lekerdezes_Funkcio(Id);
    }

    public boolean RemoveFoglalas(int Id) {
        database.deleteFoglalas(Id);
        return false;
    }

    public ArrayList<Foglalas> ReadAllFoglalasForOneDay(LocalDateTime date) {
        database.foglalas_Lekerdezes_Funkcio_Adott_nappra(date);
        return null;
    }

    public boolean ModifyFoglalas(Foglalas foglalas) {
        /*FoglalasTipus foglalasTipus;
        foglalasTipus = FoglalasTipus.Foglalas;
        database.updateFoglalas(
                foglalas.getId(),
                foglalas.getDatum(),
                foglalas.getSzemelyekSzama(),
                foglalas.getEtelallergia(),
                foglalas.getGyerekekSzama(),
                foglalas.getMegjegyzes());

        return false;*/

        int id = 0;

        int asztalSzam = 0;

        int teremSzam = 0;

        FoglalasTipus foglalasTipus;

        if (foglalas instanceof AsztalFoglalas){
            foglalasTipus = FoglalasTipus.AsztalFoglalas;

            asztalSzam = ((AsztalFoglalas) foglalas).getAsztalSzam();
        }
        else if (foglalas instanceof TeremFoglalas){
            foglalasTipus = FoglalasTipus.TeremFoglalas;

            teremSzam = ((TeremFoglalas) foglalas).getTeremSzam();
        }
        else {
            foglalasTipus = FoglalasTipus.Foglalas;
        }

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

        int asztalSzam = 0;

        int teremSzam = 0;

        FoglalasTipus foglalasTipus;

        if (foglalas instanceof AsztalFoglalas){
            foglalasTipus = FoglalasTipus.AsztalFoglalas;

            asztalSzam = ((AsztalFoglalas) foglalas).getAsztalSzam();
        }
        else if (foglalas instanceof TeremFoglalas){
            foglalasTipus = FoglalasTipus.TeremFoglalas;

            teremSzam = ((TeremFoglalas) foglalas).getTeremSzam();
        }
        else {
            foglalasTipus = FoglalasTipus.Foglalas;
        }

        id = database.insertFoglalas(
                foglalasTipus,
                foglalas.getDatum(),
                foglalas.getSzemelyekSzama(),
                foglalas.getEtelallergia(),
                foglalas.getGyerekekSzama(),
                foglalas.getMegjegyzes(),
                asztalSzam,
                teremSzam,
                foglalas.getUgyfelId());

        if (id > 0) {
            foglalas.setId(id);
            insertWasSuccessfull = true;
        }
        return insertWasSuccessfull;
    }
}
