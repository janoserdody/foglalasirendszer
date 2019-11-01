package common;

import java.time.LocalDateTime;
import java.util.Iterator;

public class TeremFoglalas extends Foglalas{

    public int getTeremSzam() {
        return teremSzam;
    }

    public void setTeremSzam(int teremSzam) {
        this.teremSzam = teremSzam;
    }

    private int teremSzam;

    public TeremFoglalas(LocalDateTime datum, int szemelyekSzama, int teremSzam){
        super(datum, szemelyekSzama);

        this.teremSzam = teremSzam;
    }
}
