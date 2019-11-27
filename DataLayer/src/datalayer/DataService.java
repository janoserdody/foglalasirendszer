package datalayer;

import common.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataService implements IDataService {

    private Database_and_Functions database;

    private LocalTimeZone localTimeZone;


    public DataService(LocalTimeZone localTimeZone){
        this.localTimeZone = localTimeZone;
         database = new Database_and_Functions(localTimeZone);
    }

    public boolean insertUgyfel(Ugyfel ugyfel) {

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

    public Ugyfel getUgyfel(int Id) {
        return database.Ugyfel_Lekerdezes_Funkcio(Id);
    }

    public Ugyfel getUgyfel(String keresztNev, String vezetekNev) {
        return database.Ugyfel_Lekerdezes_Funkcio_Keresztnev_Vezeteknev(keresztNev, vezetekNev);
    }

    public Ugyfel getUgyfel(String telefon) {
        return database.Ugyfel_Lekerdezes_Funkcio_Telefonszam(telefon);
    }

    public boolean modifyUgyfel(Ugyfel ugyfel) {
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

    public boolean removeUgyfel(int Id) {
        database.deleteUgyfel(Id);
        return false;
    }

    public ArrayList<Integer> readAllUgyfelId() {
        return database.Ugyfel_Lekerdezes_Funkcio_UgyfelID();
    }

    public Foglalas getFogalas(int Id) {
        return (Foglalas) database.foglalas_Lekerdezes_Funkcio(Id);
    }

    public boolean removeFoglalas(int Id) {
        database.deleteFoglalas(Id);
        return false;
    }

    public List<Foglalas> readAllFoglalasForOneDay(LocalDate date) {
        return database.foglalas_Lekerdezes_Funkcio_Adott_nappra(date);
    }

    public boolean modifyFoglalas(Foglalas foglalas) {
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

    public boolean insertFoglalas(Foglalas foglalas) {

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
