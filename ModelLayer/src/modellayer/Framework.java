package modellayer;

import common.Foglalas;
import common.Ugyfel;
import datalayer.DataService;
import datalayer.IDataService;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Framework implements IFramework{

    private ArrayList<Ugyfel> ugyfelLista;

    private ArrayList<Integer> ugyfelIdLista;

    private IDataService dataService;

    public Framework(){

        dataService = new DataService();

        ugyfelLista = new ArrayList<Ugyfel>();
        ugyfelLista.add(new Ugyfel("Kisasszony","Gabi", "Kis", "jhgfjhgf@freemail.hu", "1234567"));
        ugyfelLista.add(new Ugyfel("Úrhölgy","Julcsi", "Nagy", "uzuzt@freemail.hu", "9879654"));
    }

    public void hozzaadUgyfel(Ugyfel ugyfel){
        ugyfelLista.add(ugyfel);
    }

    public void torolUgyfel(Ugyfel ugyfel){
        ugyfelLista.remove(ugyfel);
    }

    public ArrayList<Ugyfel> getUgyfelLista() {
        return ugyfelLista;
    }
    
    public String[] getUgyfelNevekListaja(){
        
        String[] nevLista = new String[ugyfelLista.size()];

        int i = 0;

        for (Ugyfel ugyfel: ugyfelLista){
            nevLista[i] = ugyfel.getMegszolitas() + " " + ugyfel.getVezetekNev() + " " + ugyfel.getKeresztNev();
            i++;
        }

        return nevLista;
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
