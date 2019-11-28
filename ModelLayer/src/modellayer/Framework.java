package modellayer;

import common.Foglalas;
import common.LocalTimeZone;
import common.Ugyfel;
import datalayer.DataService;
import datalayer.IDataService;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
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
    }

    public void hozzaadUgyfel(Ugyfel ugyfel){
        dataService.insertUgyfel(ugyfel);

        Foglalas foglalas = ugyfel.getFoglalas();

        if (foglalas == null){
            ugyfelLista.add(ugyfel);
            return;
        }

        foglalas.setUgyfelId(ugyfel.getId());

        dataService.insertFoglalas(foglalas);

        ugyfelLista.add(ugyfel);
    }

    public boolean modositUgyfel(Ugyfel ugyfel){
        return dataService.modifyUgyfel(ugyfel);
    }

    public boolean torolUgyfel(Ugyfel ugyfel){
        ugyfelLista.remove(ugyfel);
        return dataService.removeUgyfel(ugyfel.getId());
    }

    public boolean torolUgyfel(int id){
        Ugyfel ugyfel = dataService.getUgyfel(id);
        ugyfelLista.remove(ugyfel);
        return dataService.removeUgyfel(id);
    }

    public ArrayList<Ugyfel> getUgyfelLista() {
        if (ugyfelLista.size() > 0){
            return ugyfelLista;
        }

        ArrayList<Integer> idList = dataService.readAllUgyfelId();

        for (int id : idList){
        ugyfelLista.add(dataService.getUgyfel(id));
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

    public Ugyfel GetUgyfel(int id){
        return  dataService.getUgyfel(id);
    }

    public ArrayList<Integer> GetUgyfelIdLista(){
        ArrayList<Integer> idList = dataService.readAllUgyfelId();
        return idList;
    }

    public String[][] getFoglalasokListaja(LocalDate fromDate, LocalDate toDate){
        getUgyfelLista();

        List<Foglalas> foglalasLista = new ArrayList<>();

        Period interval = Period.between(fromDate, toDate);

        LocalDate startDay = fromDate;

        for (int i = 0; i < interval.getDays(); i++ ){
            foglalasLista.addAll(dataService.readAllFoglalasForOneDay(startDay));
            startDay = startDay.plusDays(1);
        }

        String[][] result = new String[foglalasLista.size()][3];

        if (foglalasLista.size() == 0){
            return result;
        }

        int x = 0;

        for (Foglalas foglalas: foglalasLista
             ) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            result[x][0] = foglalas.getDatum().format(formatter);
            Ugyfel ugyfel = dataService.getUgyfel(foglalas.getUgyfelId());
            if (ugyfel != null) {
                result[x][1] = ugyfel.getMegszolitas() + " " +
                        ugyfel.getVezetekNev() + " " +
                        ugyfel.getKeresztNev();

                result[x][2] = ugyfel.getTelefon();
            }
            x++;
        }
        return result;
    }
 
    public void setUgyfelLista(ArrayList<Ugyfel> ugyfelLista) {
        this.ugyfelLista = ugyfelLista;
    }

    public boolean beolvasOsszesUgyfelId(){

        boolean result = ugyfelIdLista.addAll(dataService.readAllUgyfelId());

        return result;
    }
}
