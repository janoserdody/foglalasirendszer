package common;

import java.time.LocalDateTime;
import java.util.Date;

public class Foglalas {

    private int Id;

    private LocalDateTime datum;

    private int szemelyekSzama;

    private Allergia etelallergia;

    private int gyerekekSzama;

    private String  megjegyzes;

    public Foglalas(LocalDateTime datum, int szemelyekSzama){
        this.datum = datum;
        this.szemelyekSzama = szemelyekSzama;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }

    public int getSzemelyekSzama() {
        return szemelyekSzama;
    }

    public void setSzemelyekSzama(int szemelyekSzama) {
        this.szemelyekSzama = szemelyekSzama;
    }


    public Allergia getEtelallergia() {
        return etelallergia;
    }

    public void setEtelallergia(Allergia etelallergia) {
        this.etelallergia = etelallergia;
    }

    public int getGyerekekSzama() {
        return gyerekekSzama;
    }

    public void setGyerekekSzama(int gyerekekSzama) {
        this.gyerekekSzama = gyerekekSzama;
    }

    public String getMegjegyzes() {
        return megjegyzes;
    }

    public void setMegjegyzes(String megjegyzes) {
        this.megjegyzes = megjegyzes;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
