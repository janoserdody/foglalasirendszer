package common;

import java.util.Date;

public class Ugyfel {

    private int id;

    private String megszolitas;

    private String keresztNev;

    private String vezetekNev;

    private String email;

    private String telefon;

    private Foglalas foglalas;

    private int utolsoSzamla;

    private int osszesSzamla;

    private Date utolsoLatogatas;

    public Ugyfel(String megszolitas,
            String keresztNev,
            String vezetekNev,
            String email,
            String telefon){

        this.megszolitas = megszolitas;

        this.keresztNev = keresztNev;

        this.vezetekNev = vezetekNev;

        this.email = email;

        this.telefon = telefon;
    }

    public String getMegszolitas() {
        return megszolitas;
    }

    public void setMegszolitas(String megszolitas) {
        this.megszolitas = megszolitas;
    }

    public String getKeresztNev() {
        return keresztNev;
    }

    public void setKeresztNev(String keresztNev) {
        this.keresztNev = keresztNev;
    }

    public String getVezetekNev() {
        return vezetekNev;
    }

    public void setVezetekNev(String vezetekNev) {
        this.vezetekNev = vezetekNev;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Foglalas getFoglalas() {
        return foglalas;
    }

    public void setFoglalas(Foglalas foglalas) {
        this.foglalas = foglalas;
    }

    public int getUtolsoSzamla() {
        return utolsoSzamla;
    }

    public void setUtolsoSzamla(Integer utolsoSzamla) {
        this.utolsoSzamla = utolsoSzamla;
    }

    public Date getUtolsoLatogatas() {
        return utolsoLatogatas;
    }

    public void setUtolsoLatogatas(Date utolsoLatogatas) {
        this.utolsoLatogatas = utolsoLatogatas;
    }
}
