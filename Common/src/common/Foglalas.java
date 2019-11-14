package common;

import java.time.LocalDateTime;

public class Foglalas {

    protected int id = 0;

    protected LocalDateTime datum;

    protected String megszolitas;

    protected int szemelyekSzama;

    protected Allergia etelallergia;

    protected int gyerekekSzama;

    protected String  megjegyzes;

    protected int ugyfelId;

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
    public void setMegszolitas(String megszolitas){this.megszolitas=megszolitas;}

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
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUgyfelId() {
        return ugyfelId;
    }

    public void setUgyfelId(int ugyfelId) {
        this.ugyfelId = ugyfelId;
    }
}
