package common;

import java.time.LocalDateTime;

public class AsztalFoglalas extends Foglalas {

    private int asztalSzam;

    public AsztalFoglalas(LocalDateTime datum, int szemelyekSzama, int asztalSzam){
        super(datum, szemelyekSzama);

        this.asztalSzam = asztalSzam;
    }

    public int getAsztalSzam() {
        return asztalSzam;
    }

    public void setAsztalSzam(int asztalSzam) {
        this.asztalSzam = asztalSzam;
    }
}
