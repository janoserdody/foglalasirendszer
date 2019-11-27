package modellayer;

import common.Foglalas;
import common.LocalTimeZone;
import common.Ugyfel;
import datalayer.DataService;
import datalayer.IDataService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Framework implements IFramework{

    private ArrayList<Ugyfel> ugyfelLista;

    private ArrayList<Integer> ugyfelIdLista;

    private IDataService dataService;

    private LocalTimeZone localTimeZone;

    public Framework(){
        localTimeZone = new LocalTimeZone();

        dataService = new DataService(localTimeZone);

        ugyfelLista = new ArrayList<Ugyfel>();
        //ugyfelLista.add(new Ugyfel("Kisasszony","Gabi", "Kis", "jhgfjhgf@freemail.hu", "1234567"));
        //ugyfelLista.add(new Ugyfel("Úrhölgy","Julcsi", "Nagy", "uzuzt@freemail.hu", "9879654"));
    }

    public  void hozzaadUgyfel2(Ugyfel ugyfel){
        dataService.InsertUgyfel(ugyfel);
        ugyfelLista.add(ugyfel);
    }

    public void hozzaadUgyfel(Ugyfel ugyfel){
        dataService.InsertUgyfel(ugyfel);

        Foglalas foglalas = ugyfel.getFoglalas();

        if (foglalas == null){
            ugyfelLista.add(ugyfel);
            return;
        }

        foglalas.setUgyfelId(ugyfel.getId());

        dataService.InsertFoglalas(foglalas);

        ugyfelLista.add(ugyfel);
    }

    public void torolUgyfel(Ugyfel ugyfel){
        ugyfelLista.remove(ugyfel);
    }

    public ArrayList<Ugyfel> getUgyfelLista() {
        if (ugyfelLista.size() > 0){
            return ugyfelLista;
        }

        ArrayList<Integer> idList = dataService.ReadAllUgyfelId();


        for (int id : idList){
        ugyfelLista.add(dataService.GetUgyfel(id));
        }

        return ugyfelLista;
    }
    
    public String[] getUgyfelNevekListaja(){

        getUgyfelLista();
        
        String[] nevLista = new String[ugyfelLista.size()];

        int i = 0;

        for (Ugyfel ugyfel: ugyfelLista){
            nevLista[i] = ugyfel.getMegszolitas() + " " + ugyfel.getVezetekNev() + " " + ugyfel.getKeresztNev();
            i++;
        }

        return nevLista;
    }

    public String[][] getFoglalasokListaja(LocalDate fromDate, LocalDate toDate){
        getUgyfelLista();

        List<Foglalas> foglalasLista = new ArrayList<>();

        Period interval = Period.between(fromDate, toDate);

        LocalDate startDay = fromDate;

        for (int i = 0; i < interval.getDays(); i++ ){
            foglalasLista.addAll(dataService.ReadAllFoglalasForOneDay(startDay));
            startDay = startDay.plusDays(1);
        }

        String[][] result = new String[foglalasLista.size()][3];

        int x = 0;

        for (Foglalas foglalas: foglalasLista
             ) {
            result[x][0] = foglalas.getDatum().toLocalDate().toString();
            Ugyfel ugyfel = dataService.GetUgyfel(foglalas.getUgyfelId());
            result[x][1] = ugyfel.getMegszolitas() + " " +
                    ugyfel.getVezetekNev() + " " +
                    ugyfel.getKeresztNev();

            result[x][2] = ugyfel.getTelefon();
            x++;
        }
        return result;
    }
 
    public void setUgyfelLista(ArrayList<Ugyfel> ugyfelLista) {
        this.ugyfelLista = ugyfelLista;
    }

    public boolean beolvasOsszesUgyfelId(){

        boolean result = ugyfelIdLista.addAll(dataService.ReadAllUgyfelId());

        return result;
    }

    public ArrayList<Integer> beolvasEgyNapFoglalasok(LocalDateTime date){

        return null;
    }

    public ArrayList<Foglalas> beolvasIntervallumFoglalasok(LocalDateTime fromDate, LocalDateTime toDate) {

        LocalDateTime date = fromDate;

        ArrayList<Integer> foglalasokIntervallum = new ArrayList<>();

        do {
            foglalasokIntervallum.addAll(beolvasEgyNapFoglalasok(date));

            date = date.plusDays(1);

        } while (date.isBefore(toDate));

        ArrayList<Foglalas> foglalasok = new ArrayList<>();

        for (Integer foglalasId: foglalasokIntervallum
             ) {
            foglalasok.add(dataService.GetFogalas(foglalasId));
        }

        return foglalasok;
    }
}
