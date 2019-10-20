package common;

import java.util.Date;

public class CsaladosUgyfel extends Ugyfel{

    private int gyerekekSzama;

    public CsaladosUgyfel(String megszolitas,
                          String keresztNev,
                          String vezetekNev,
                          String email,
                          String telefon,
                          int gyerekekSzama){
        super(megszolitas, keresztNev, vezetekNev, email, telefon);

        this.gyerekekSzama = gyerekekSzama;
    }


    public int getGyerekekSzama() {
        return gyerekekSzama;
    }

    public void setGyerekekSzama(int gyerekekSzama) {
        this.gyerekekSzama = gyerekekSzama;
    }
}
