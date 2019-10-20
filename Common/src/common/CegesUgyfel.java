package common;

public class CegesUgyfel extends Ugyfel{

    private String cegNev;

    private  String szamlazasiCim;

    public CegesUgyfel(String megszolitas,
                       String keresztNev,
                       String vezetekNev,
                       String email,
                       String telefon,
                       String cegNev,
                       String szamlazasiCim){
        super(megszolitas, keresztNev, vezetekNev, email, telefon);

        this.cegNev = cegNev;

        this.szamlazasiCim = szamlazasiCim;
    }

    public String getSzamlazasiCim() {
        return szamlazasiCim;
    }

    public void setSzamlazasiCim(String szamlazasiCim) {
        this.szamlazasiCim = szamlazasiCim;
    }

    public String getCegNev() {
        return cegNev;
    }

    public void setCegNev(String cegNev) {
        this.cegNev = cegNev;
    }
}
