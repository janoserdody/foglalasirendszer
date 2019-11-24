package datalayer;

import common.Allergia;

import java.time.LocalDateTime;

public class QueryFoglalasLekerdezes {

    //Ez az osztály kell ahhoz, hogy lehessen olyan tömböt generálni,
    //ami képes tárolni a query által lekért adatokat

//     + TABLE_UGYFEL + "." + COLUMN_UGYFEL_ID + ", "
//            + TABLE_UGYFEL + "." + COLUMN_UGYFEL_MEGSZOLITAS + ", "
//            + TABLE_UGYFEL + "." + COLUMN_UGYFEL_KERESZTNEV + ", "
//            + TABLE_UGYFEL + "." + COLUMN_UGYFEL_VEZETEKNEV + ", "
//            + TABLE_FOGLALAS + "." + COLUMN_FOGLALAS_ID + ", "
//            + TABLE_FOGLALAS + "." + COLUMN_FOGLALAS_DATUM + ", "
//            + TABLE_FOGLALAS + "." + COLUMN_FOGLALAS_SZEMELYEKSZAMA + ", "
//            + TABLE_FOGLALAS + "." + COLUMN_FOGLALAS_ETELALLERGIA + ", "
//            + TABLE_FOGLALAS + "." + COLUMN_FOGLALAS_GYEREKEKSZAMA + ", "
//            + TABLE_FOGLALAS + "." + COLUMN_FOGLALAS_MEGJEGYZES + ", "

    private String UGYFEL_MEGSZOLITAS_QUERY;
    private String UGYFEL_KERESZTNEV_QUERY;
    private String UGYFEL_VEZETEKNEV_QUERY;
    private Integer FOGLALAS_ID_QUERY;
    private LocalDateTime FOGLALAS_DATUM_QUERY;
    private Integer FOGLALAS_SZEMELYEKSZAMA_QUERY;
    private Allergia FOGLALAS_ETELALLERGIA_QUERY;
    private Integer FOGLALAS_GYEREKEKSZAMA_QUERY;
    private String FOGLALAS_MEGJEGYZES_QUERY;

    public Integer getFOGLALAS_TEREMSZAM_QUERY() {
        return FOGLALAS_TEREMSZAM_QUERY;
    }

    public void setFOGLALAS_TEREMSZAM_QUERY(Integer FOGLALAS_TEREMSZAM_QUERY) {
        this.FOGLALAS_TEREMSZAM_QUERY = FOGLALAS_TEREMSZAM_QUERY;
    }

    private Integer FOGLALAS_TEREMSZAM_QUERY;


    public Integer getFOGLALAS_ASZTALSZAM_QUERY() {
        return FOGLALAS_ASZTALSZAM_QUERY;
    }

    public void setFOGLALAS_ASZTALSZAM_QUERY(Integer FOGLALAS_ASZTALSZAM_QUERY) {
        this.FOGLALAS_ASZTALSZAM_QUERY = FOGLALAS_ASZTALSZAM_QUERY;
    }

    private Integer FOGLALAS_ASZTALSZAM_QUERY;

    public Integer getFOGLALAS_TIPUS_QUERY() {
        return FOGLALAS_TIPUS_QUERY;
    }

    public void setFOGLALAS_TIPUS_QUERY(Integer FOGLALAS_TIPUS_QUERY) {
        this.FOGLALAS_TIPUS_QUERY = FOGLALAS_TIPUS_QUERY;
    }

    private Integer FOGLALAS_TIPUS_QUERY;

    public Integer getFOGLALAS_UGYFEL_ID() {
        return FOGLALAS_UGYFEL_ID;
    }

    public void setFOGLALAS_UGYFEL_ID(Integer FOGLALAS_UGYFEL_ID) {
        this.FOGLALAS_UGYFEL_ID = FOGLALAS_UGYFEL_ID;
    }

    private Integer FOGLALAS_UGYFEL_ID;

    public String getUGYFEL_MEGSZOLITAS_QUERY() {
        return UGYFEL_MEGSZOLITAS_QUERY;
    }

    public void setUGYFEL_MEGSZOLITAS_QUERY(String UGYFEL_MEGSZOLITAS_QUERY) {
        this.UGYFEL_MEGSZOLITAS_QUERY = UGYFEL_MEGSZOLITAS_QUERY;
    }

    public String getUGYFEL_KERESZTNEV_QUERY() {
        return UGYFEL_KERESZTNEV_QUERY;
    }

    public void setUGYFEL_KERESZTNEV_QUERY(String UGYFEL_KERESZTNEV_QUERY) {
        this.UGYFEL_KERESZTNEV_QUERY = UGYFEL_KERESZTNEV_QUERY;
    }

    public String getUGYFEL_VEZETEKNEV_QUERY() {
        return UGYFEL_VEZETEKNEV_QUERY;
    }

    public void setUGYFEL_VEZETEKNEV_QUERY(String UGYFEL_VEZETEKNEV_QUERY) {
        this.UGYFEL_VEZETEKNEV_QUERY = UGYFEL_VEZETEKNEV_QUERY;
    }

    public Integer getFOGLALAS_ID_QUERY() {
        return FOGLALAS_ID_QUERY;
    }

    public void setFOGLALAS_ID_QUERY(Integer FOGLALAS_ID_QUERY) {
        this.FOGLALAS_ID_QUERY = FOGLALAS_ID_QUERY;
    }

    public LocalDateTime getFOGLALAS_DATUM_QUERY() {
        return FOGLALAS_DATUM_QUERY;
    }

    public void setFOGLALAS_DATUM_QUERY(LocalDateTime FOGLALAS_DATUM_QUERY) {
        this.FOGLALAS_DATUM_QUERY = FOGLALAS_DATUM_QUERY;
    }

    public Integer getFOGLALAS_SZEMELYEKSZAMA_QUERY() {
        return FOGLALAS_SZEMELYEKSZAMA_QUERY;
    }

    public void setFOGLALAS_SZEMELYEKSZAMA_QUERY(Integer FOGLALAS_SZEMELYEKSZAMA_QUERY) {
        this.FOGLALAS_SZEMELYEKSZAMA_QUERY = FOGLALAS_SZEMELYEKSZAMA_QUERY;
    }

    public Allergia getFOGLALAS_ETELALLERGIA_QUERY() {
        return FOGLALAS_ETELALLERGIA_QUERY;
    }

    public void setFOGLALAS_ETELALLERGIA_QUERY(Allergia FOGLALAS_ETELALLERGIA_QUERY) {
        this.FOGLALAS_ETELALLERGIA_QUERY = FOGLALAS_ETELALLERGIA_QUERY;
    }

    public Integer getFOGLALAS_GYEREKEKSZAMA_QUERY() {
        return FOGLALAS_GYEREKEKSZAMA_QUERY;
    }

    public void setFOGLALAS_GYEREKEKSZAMA_QUERY(Integer FOGLALAS_GYEREKEKSZAMA_QUERY) {
        this.FOGLALAS_GYEREKEKSZAMA_QUERY = FOGLALAS_GYEREKEKSZAMA_QUERY;
    }

    public String getFOGLALAS_MEGJEGYZES_QUERY() {
        return FOGLALAS_MEGJEGYZES_QUERY;
    }

    public void setFOGLALAS_MEGJEGYZES_QUERY(String FOGLALAS_MEGJEGYZES_QUERY) {
        this.FOGLALAS_MEGJEGYZES_QUERY = FOGLALAS_MEGJEGYZES_QUERY;
    }
}
