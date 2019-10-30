package common;

import java.time.LocalDateTime;
import java.util.Iterator;

public class TeremFoglalas extends Foglalas{

    private int teremSzam;


    public void setTeremSzam(int teremSzam) {
        this.teremSzam = teremSzam;
    }

    public TeremFoglalas(LocalDateTime datum, int szemelyekSzama, int teremSzam){
        super(datum, szemelyekSzama);

        this.teremSzam = teremSzam;
    }
}
