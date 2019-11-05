package datalayer;

import common.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;

// Ebben az osztályban a következők találhatók:
//- adatbázis elérési útja
//- a kapcsolat nyitása az adatbázishoz
//- a különböző methódusok, amik az adatbázishoz kellenek

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;

public class Database_and_Functions {

    // Példa a hívásra:

//        Database_and_Functions DB_Muveletek = new Database_and_Functions();
//        // insert new rows
//        DB_Muveletek.insertUgyfel("Úr", "Tibor","Molnár","xy@gmail.com", 22222222,10000, 20000,“2015-01-01”);//

    private LocalTimeZone localTimeZone;

    public Database_and_Functions(LocalTimeZone localTimeZone) {
        this.localTimeZone = localTimeZone;
    }

    /**
     * Connect to the Foglalasok.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:d:\\source\\foglalasirendszer2\\Foglalasok.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    //******************************
    //******Insert funckciók********

    /**
     * Insert a new row into the Ugyfel table
     *
     * @param megszolitas
     * @param keresztNev
     * @param vezetekNev
     * @param email
     * @param telefon
     * @param utolszoSzamla
     * @param osszesSzamla
     * @param utolsoLatogatas
     */
    public int insertUgyfel(UgyfelTipus ugyfelTipus, String megszolitas, String keresztNev, String vezetekNev, String email,
                            String telefon, int utolszoSzamla, int osszesSzamla, java.time.LocalDate utolsoLatogatas,
                            String cegNev, String szamlazasiCim, int gyerekekSzama) {

        ResultSet rs = null;
        int id = 0;

        String sql = "INSERT INTO Ugyfel (megszolitas, keresztNev, vezetekNev, email, telefon," +
                " utolsoSzamla, osszesSzamla, utolsoLatogatas, cegNev, szamlazasiCim, gyerekekSzama, ugyfelTipus) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

//        valueOf(String s) : This method converts a string in JDBC date escape format to a Date value using
//        specified value of s- a String object representing a date in the format “yyyy-[m]m-[d]d”.
//        The leading zero for mm and dd may also be omitted.

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql,
                     Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, megszolitas);
            pstmt.setString(2, keresztNev);
            pstmt.setString(3, vezetekNev);
            pstmt.setString(4, email);
            pstmt.setString(5, telefon);
            pstmt.setInt(6, utolszoSzamla);
            pstmt.setInt(7, osszesSzamla);
            // TODO javítani a get ugyfelnél
            pstmt.setDate(8, Date.valueOf(utolsoLatogatas));
            pstmt.setString(9, cegNev);
            pstmt.setString(10, szamlazasiCim);
            pstmt.setInt(11, gyerekekSzama);
            pstmt.setInt(12, ugyfelTipus.getValue());
            int rowAffected = pstmt.executeUpdate();
            if (rowAffected == 1) {
                rs = pstmt.getGeneratedKeys();
                if (rs.next())
                    id = rs.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
        return id;
    }

    public int insertFoglalas(FoglalasTipus foglalasTipus, LocalDateTime datum, int szemelyekSzama, Allergia etelallergia,
                              int gyerekekSzama, String megjegyzes, int asztalSzam, int teremSzam, int ugyfelId) {

        ResultSet rs = null;
        int id = 0;

        String sql = "INSERT INTO Foglalas (datum, szemelyekSzama, etelallergia, gyerekekSzama, megjegyzes, foglalasTipus," +
                "asztalSzam, teremSzam, ugyfelId) " +
                "VALUES(?,?,?,?,?,?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql,
                     Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setTimestamp(1, new java.sql.Timestamp(datum.atZone(localTimeZone.getLocalTimeZoneId()).toInstant()
                    .toEpochMilli()));
            pstmt.setInt(2, szemelyekSzama);
            pstmt.setInt(3, etelallergia.getValue());
            pstmt.setInt(4, gyerekekSzama);
            pstmt.setString(5, megjegyzes);
            pstmt.setInt(6, foglalasTipus.getValue());
            pstmt.setInt(7, asztalSzam);
            pstmt.setInt(8, teremSzam);
            pstmt.setInt(9, ugyfelId);
            int rowAffected = pstmt.executeUpdate();
            if (rowAffected == 1) {
                rs = pstmt.getGeneratedKeys();
                if (rs.next())
                    id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
        return id;
    }


    //******************************
    //*******Delete funkciók********

    public void deleteCegesUgyfel(String cegNev) {
        String sql = "DELETE FROM Ugyfel WHERE cegNev = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, cegNev);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteFoglalas(int id) {
        String sql = "DELETE FROM Foglalas WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();
            System.out.println(id + " azonsítojú foglalás eltávolitva.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteTeremFoglalas(int teremSzam) {
        String sql = "DELETE FROM TeremFoglalas WHERE teremSzam = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, teremSzam);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteUgyfel(int id) {
        String sql = "DELETE FROM Ugyfel WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();
            System.out.println(id + " azonsítojú ügyfél eltávolitva.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //******************************
    //******Update funckciók********


    //Modify ugyfel-t ki kellett egyészíteni a korábbi kereszt és vezetéknévvel, hogy a query megtalálja a felülírandót
    public boolean ModifyUgyfel(int id, UgyfelTipus ugyfelTipus, String megszolitas, String keresztNev, String vezetekNev, String email,
                            String telefon, int utolszoSzamla, int osszesSzamla, LocalDate utolsoLatogatas,
                            String cegNev, String szamlazasiCim, int gyerekekSzama) {

        ResultSet rs = null;

        boolean result = false;

        String sql = "UPDATE Ugyfel " +
                "SET " +
                "megszolitas = ?, " +
                "keresztNev = ?, " +
                "vezetekNev = ?, " +
                "email = ?, " +
                "telefon = ?, " +
                "utolsoSzamla = ?, " +
                "osszesSzamla = ?, " +
                "utolsoLatogatas = ?, " +
                "cegNev = ?, " +
                "szamlazasiCim = ?, " +
                "gyerekekSzama = ?, " +
                "ugyfelTipus = ? " +
                "WHERE id is ?";

//        valueOf(String s) : This method converts a string in JDBC date escape format to a Date value using
//        specified value of s- a String object representing a date in the format “yyyy-[m]m-[d]d”.
//        The leading zero for mm and dd may also be omitted.

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql,
                     Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, megszolitas);
            pstmt.setString(2, keresztNev);
            pstmt.setString(3, vezetekNev);
            pstmt.setString(4, email);
            pstmt.setString(5, telefon);
            pstmt.setInt(6, utolszoSzamla);
            pstmt.setInt(7, osszesSzamla);
            pstmt.setDate(8, Date.valueOf(utolsoLatogatas));
            pstmt.setString(9, cegNev);
            pstmt.setString(10, szamlazasiCim);
            pstmt.setInt(11, gyerekekSzama);
            pstmt.setInt(12, ugyfelTipus.getValue());
            pstmt.setInt(13, id);
            int rowAffected = pstmt.executeUpdate();
            if (rowAffected == 1) {
                result = true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return result;
    }

    public void updateFoglalas(int id, LocalDateTime datum, int szemelyekSzama,
                               Allergia etelallergia, int gyerekekSzama, String megjegyzes) {
        String sql = "UPDATE Foglalas " +
                "SET datum = ?, szemelyekSzama = ?, etelallergia = ?, gyerekekSzama = ?, megjegyzes = ? " +
                "WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setTimestamp(1, new java.sql.Timestamp(datum.atZone(localTimeZone.getLocalTimeZoneId()).toInstant()
                    .toEpochMilli()));
            pstmt.setInt(2, szemelyekSzama);
            pstmt.setInt(3, etelallergia.getValue());
            pstmt.setInt(4, gyerekekSzama);
            pstmt.setString(5, megjegyzes);
            pstmt.setInt(6, id);

            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //******************************
    //*********Lekérdezések*********

    //Needed queries:
    // List of ugyfel's, list of foglalasok

    public static final String QUERY_LEKERESFOGLALAS =
            "SELECT id, datum, szemelyekSzama, etelallergia, " +
                    "gyerekekSzama, megjegyzes FROM Foglalas WHERE ugyfelId = ?";

    public List<Foglalas> foglalas_Lekerdezes_Funkcio(int id) {

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(QUERY_LEKERESFOGLALAS);
            pstmt.setInt(1, id);
            ResultSet results = pstmt.executeQuery();

            List<QueryFoglalasLekerdezes> foglalasok = new ArrayList<>();
            while (results.next()) {
                QueryFoglalasLekerdezes aktualisFoglalas = new QueryFoglalasLekerdezes();
                aktualisFoglalas.setUGYFEL_MEGSZOLITAS_QUERY(results.getString(1));
                aktualisFoglalas.setUGYFEL_KERESZTNEV_QUERY(results.getString(2));
                aktualisFoglalas.setUGYFEL_VEZETEKNEV_QUERY(results.getString(3));
                aktualisFoglalas.setFOGLALAS_ID_QUERY(results.getInt(4));
                aktualisFoglalas.setFOGLALAS_DATUM_QUERY(results.getTimestamp(5).toLocalDateTime());
                aktualisFoglalas.setFOGLALAS_SZEMELYEKSZAMA_QUERY(results.getInt(6));
                aktualisFoglalas.setFOGLALAS_ETELALLERGIA_QUERY(Allergia.valueOf(results.getInt(7)));
                aktualisFoglalas.setFOGLALAS_GYEREKEKSZAMA_QUERY(results.getInt(8));
                aktualisFoglalas.setFOGLALAS_MEGJEGYZES_QUERY(results.getString(9));
                aktualisFoglalas.setFOGLALAS_UGYFEL_ID(results.getInt(10));
                foglalasok.add(aktualisFoglalas);
            }
            System.out.println(Arrays.toString(foglalasok.toArray()));

            List<Foglalas> foglalasList = new ArrayList<>();

            for (QueryFoglalasLekerdezes lekerdezes: foglalasok){
                Foglalas foglalas = GetFoglalas(lekerdezes);
                foglalasList.add(foglalas);
            }

            return foglalasList;

        } catch (SQLException e) {
            System.out.println("Query sikertelen. Hiba: " + e.getMessage());
            return null;
        }
    }

    private Foglalas GetFoglalas(QueryFoglalasLekerdezes lekerdezes) {
        Foglalas foglalas = new Foglalas(lekerdezes.getFOGLALAS_DATUM_QUERY(), lekerdezes.getFOGLALAS_SZEMELYEKSZAMA_QUERY());

        foglalas.setUgyfelId(lekerdezes.getFOGLALAS_UGYFEL_ID());

        foglalas.setGyerekekSzama(lekerdezes.getFOGLALAS_GYEREKEKSZAMA_QUERY());

        foglalas.setMegjegyzes(lekerdezes.getFOGLALAS_MEGJEGYZES_QUERY());

        foglalas.setEtelallergia(lekerdezes.getFOGLALAS_ETELALLERGIA_QUERY());

        foglalas.setId(lekerdezes.getFOGLALAS_ID_QUERY());

        return foglalas;

    }

    public static final String QUERY_LEKERESFOGLALAS_ADOTT_NAPRA =
            "SELECT Ugyfel.id, Ugyfel.megszolitas, Ugyfel.keresztNev, Ugyfel.vezetekNev, "
                    + "Foglalas.id, Foglalas.datum, Foglalas.szemelyekSzama, Foglalas.etelallergia, " +
                    "Foglalas.gyerekekSzama, Foglalas.megjegyzes FROM Ugyfel INNER JOIN Foglalas ON " +
                    "Ugyfel.id = Foglalas.id WHERE Foglalas.datum = ?";

    public List<QueryFoglalasLekerdezes> foglalas_Lekerdezes_Funkcio_Adott_nappra(LocalDateTime datum) {

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(QUERY_LEKERESFOGLALAS_ADOTT_NAPRA);
            ResultSet results = pstmt.executeQuery();

            List<QueryFoglalasLekerdezes> foglalasok = new ArrayList<>();
            while (results.next()) {
                QueryFoglalasLekerdezes aktualisFoglalas = new QueryFoglalasLekerdezes();
                aktualisFoglalas.setUGYFEL_MEGSZOLITAS_QUERY(results.getString(1));
                aktualisFoglalas.setUGYFEL_KERESZTNEV_QUERY(results.getString(2));
                aktualisFoglalas.setUGYFEL_VEZETEKNEV_QUERY(results.getString(3));
                aktualisFoglalas.setFOGLALAS_ID_QUERY(results.getInt(4));
                aktualisFoglalas.setFOGLALAS_DATUM_QUERY(results.getTimestamp(5).toLocalDateTime());
                aktualisFoglalas.setFOGLALAS_SZEMELYEKSZAMA_QUERY(results.getInt(6));
                aktualisFoglalas.setFOGLALAS_ETELALLERGIA_QUERY(Allergia.valueOf(results.getInt(7)));
                aktualisFoglalas.setFOGLALAS_GYEREKEKSZAMA_QUERY(results.getInt(8));
                aktualisFoglalas.setFOGLALAS_MEGJEGYZES_QUERY(results.getString(9));
                foglalasok.add(aktualisFoglalas);

            }
            System.out.println(Arrays.toString(foglalasok.toArray()));
            return foglalasok;


        } catch (SQLException e) {
            System.out.println("Query sikertelen. Hiba: " + e.getMessage());
            return null;
        }

    }

    public static final String SELECT_UGYFEL_QUERY =
            "SELECT id, megszolitas, keresztNev, vezetekNev, " +
                    "email, telefon, utolsoSzamla, osszesSzamla, utolsoLatogatas, cegNev, szamlazasiCim, gyerekekSzama, ugyfelTipus " +
                    "FROM Ugyfel WHERE id = ?";

    public Ugyfel Ugyfel_Lekerdezes_Funkcio(int id) {

        try {
            Connection conn = this.connect();

            PreparedStatement pstmt = conn.prepareStatement(SELECT_UGYFEL_QUERY);

            pstmt.setInt(1, id);

            ResultSet results = pstmt.executeQuery();

            Ugyfel ugyfel = null;

                QueryUgyfelLekerdezes aktualis_Ugyfel = new QueryUgyfelLekerdezes();
                aktualis_Ugyfel.setAKTUALIS_UGYFEL_ID(results.getInt(1));
                aktualis_Ugyfel.setAKTUALIS_UGYFEL_MEGSZOLITAS(results.getString(2));
                aktualis_Ugyfel.setAKTUALIS_UGYFEL_KERESZTNEV(results.getString(3));
                aktualis_Ugyfel.setAKTUALIS_UGYFEL_VEZETEKNEV(results.getString(4));
                aktualis_Ugyfel.setAKTUALIS_UGYFEL_EMAIL(results.getString(5));
                aktualis_Ugyfel.setAKTUALIS_UGYFEL_TELEFON(results.getString(6));
                aktualis_Ugyfel.setAKTUALIS_UGYFEL_UTOLSO_SZAMLA(results.getInt(7));
                aktualis_Ugyfel.setAKTUALIS_UGYFEL_OSSZES_SZAMLA(results.getInt(8));
                aktualis_Ugyfel.setAKTUALIS_UGYFEL_UTOLSO_LAtOGATAS(results.getDate(9).toLocalDate());
                aktualis_Ugyfel.setAKTUALIS_UGYFEL_CEGNEV(results.getString(10));
                aktualis_Ugyfel.setAKTUALIS_UGYFEL_SZAMLAZASI_CIM(results.getString(11));
                aktualis_Ugyfel.setAKTUALIS_UGYFEL_GYEREKEK_SZAMA(results.getInt(12));
                aktualis_Ugyfel.setAKTUALIS_UGYFEL_UGYFEL_TIPUS(UgyfelTipus.valueOf(results.getInt(13)));

                ugyfel = CopyUgyfelAdatok(aktualis_Ugyfel, ugyfel);

            return ugyfel;


        } catch (SQLException e) {
            System.out.println("Query sikertelen. Hiba: " + e.getMessage());
            return null;
        }

    }

    private Ugyfel CopyUgyfelAdatok(QueryUgyfelLekerdezes aktualis_Ugyfel, Ugyfel ugyfel) {
        if (aktualis_Ugyfel.getAKTUALIS_UGYFEL_UGYFEL_TIPUS() == UgyfelTipus.CsaladosUgyfel){
            ugyfel = GetCsaladosUgyfel(aktualis_Ugyfel);
        }
        else if (aktualis_Ugyfel.getAKTUALIS_UGYFEL_UGYFEL_TIPUS() == UgyfelTipus.CegesUgyfel){
            ugyfel = GetCegesUgyfel(aktualis_Ugyfel);
        }
        else{
            ugyfel = GetUgyfel(aktualis_Ugyfel);
        }

        ugyfel.setUtolsoLatogatas(aktualis_Ugyfel.getAKTUALIS_UGYFEL_UTOLSO_LAtOGATAS());
        ugyfel.setUtolsoSzamla(aktualis_Ugyfel.getAKTUALIS_UGYFEL_UTOLSO_SZAMLA());
        ugyfel.setOsszesSzamla(aktualis_Ugyfel.getAKTUALIS_UGYFEL_OSSZES_SZAMLA());
        ugyfel.setId(aktualis_Ugyfel.getAKTUALIS_UGYFEL_ID());

        return ugyfel;
    }

    private Ugyfel GetUgyfel(QueryUgyfelLekerdezes aktualis_Ugyfel) {
        Ugyfel ugyfel = new Ugyfel(aktualis_Ugyfel.getAKTUALIS_UGYFEL_MEGSZOLITAS(),
                aktualis_Ugyfel.getAKTUALIS_UGYFEL_KERESZTNEV(),
                aktualis_Ugyfel.getAKTUALIS_UGYFEL_VEZETEKNEV(),
                aktualis_Ugyfel.getAKTUALIS_UGYFEL_EMAIL(),
                aktualis_Ugyfel.getAKTUALIS_UGYFEL_TELEFON());
        return ugyfel;
    }

    private Ugyfel GetCegesUgyfel(QueryUgyfelLekerdezes aktualis_Ugyfel) {
        Ugyfel ugyfel = new CegesUgyfel(aktualis_Ugyfel.getAKTUALIS_UGYFEL_MEGSZOLITAS(),
                aktualis_Ugyfel.getAKTUALIS_UGYFEL_KERESZTNEV(),
                aktualis_Ugyfel.getAKTUALIS_UGYFEL_VEZETEKNEV(),
                aktualis_Ugyfel.getAKTUALIS_UGYFEL_EMAIL(),
                aktualis_Ugyfel.getAKTUALIS_UGYFEL_TELEFON(),
                aktualis_Ugyfel.getAKTUALIS_UGYFEL_CEGNEV(),
                aktualis_Ugyfel.getAKTUALIS_UGYFEL_SZAMLAZASI_CIM());
        return ugyfel;
    }

    private Ugyfel GetCsaladosUgyfel(QueryUgyfelLekerdezes aktualis_Ugyfel) {
        Ugyfel ugyfel = new CsaladosUgyfel(aktualis_Ugyfel.getAKTUALIS_UGYFEL_MEGSZOLITAS(),
                aktualis_Ugyfel.getAKTUALIS_UGYFEL_KERESZTNEV(),
                aktualis_Ugyfel.getAKTUALIS_UGYFEL_VEZETEKNEV(),
                aktualis_Ugyfel.getAKTUALIS_UGYFEL_EMAIL(),
                aktualis_Ugyfel.getAKTUALIS_UGYFEL_TELEFON(),
                aktualis_Ugyfel.getAKTUALIS_UGYFEL_GYEREKEK_SZAMA());
        return ugyfel;
    }

    public static final String SELECT_UGYFEL_WITH_KERESZTNEV_AND_VEZETEKNEV_QUERY =
            "SELECT Ugyfel.id, Ugyfel.megszolitas, Ugyfel.keresztNev, Ugyfel.vezetekNev, " +
                    "Ugyfel.email, Ugyfel.telefon " +
                    "FROM Ugyfel WHERE (Ugyfel.keresztNev is \"?\") AND (Ugyfel.vezetekNev is \"?\")";

    public List<QueryUgyfelLekerdezes> Ugyfel_Lekerdezes_Funkcio_Keresztnev_Vezeteknev(String keresztnev, String vezeteknev) {

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(SELECT_UGYFEL_WITH_KERESZTNEV_AND_VEZETEKNEV_QUERY);
            ResultSet results = pstmt.executeQuery();

            List<QueryUgyfelLekerdezes> lekert_ugyfelek = new ArrayList<>();
            while (results.next()) {
                QueryUgyfelLekerdezes aktualis_Ugyfel = new QueryUgyfelLekerdezes();
                aktualis_Ugyfel.setAKTUALIS_UGYFEL_ID(results.getInt(1));
                aktualis_Ugyfel.setAKTUALIS_UGYFEL_MEGSZOLITAS(results.getString(2));
                aktualis_Ugyfel.setAKTUALIS_UGYFEL_KERESZTNEV(results.getString(3));
                aktualis_Ugyfel.setAKTUALIS_UGYFEL_VEZETEKNEV(results.getString(4));
                aktualis_Ugyfel.setAKTUALIS_UGYFEL_EMAIL(results.getString(5));
                aktualis_Ugyfel.setAKTUALIS_UGYFEL_TELEFON(results.getString(6));
                lekert_ugyfelek.add(aktualis_Ugyfel);
            }
            System.out.println(Arrays.toString(lekert_ugyfelek.toArray()));
            return lekert_ugyfelek;


        } catch (SQLException e) {
            System.out.println("Query sikertelen. Hiba: " + e.getMessage());
            return null;
        }

    }

    public static final String SELECT_UGYFEL_WITH_TELEFONSZAM_QUERY =
            "SELECT Ugyfel.id, Ugyfel.megszolitas, Ugyfel.keresztNev, Ugyfel.vezetekNev, " +
                    "Ugyfel.email, Ugyfel.telefon " +
                    "FROM Ugyfel WHERE Ugyfel.telefon = \"?\"";

    public List<QueryUgyfelLekerdezes> Ugyfel_Lekerdezes_Funkcio_Telefonszam(String telefonSzam) {

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(SELECT_UGYFEL_WITH_TELEFONSZAM_QUERY);
            ResultSet results = pstmt.executeQuery();

            List<QueryUgyfelLekerdezes> lekert_ugyfelek = new ArrayList<>();
            while (results.next()) {
                QueryUgyfelLekerdezes aktualis_Ugyfel = new QueryUgyfelLekerdezes();
                aktualis_Ugyfel.setAKTUALIS_UGYFEL_ID(results.getInt(1));
                aktualis_Ugyfel.setAKTUALIS_UGYFEL_MEGSZOLITAS(results.getString(2));
                aktualis_Ugyfel.setAKTUALIS_UGYFEL_KERESZTNEV(results.getString(3));
                aktualis_Ugyfel.setAKTUALIS_UGYFEL_VEZETEKNEV(results.getString(4));
                aktualis_Ugyfel.setAKTUALIS_UGYFEL_EMAIL(results.getString(5));
                aktualis_Ugyfel.setAKTUALIS_UGYFEL_TELEFON(results.getString(6));
                lekert_ugyfelek.add(aktualis_Ugyfel);
            }
            System.out.println(Arrays.toString(lekert_ugyfelek.toArray()));
            return lekert_ugyfelek;


        } catch (SQLException e) {
            System.out.println("Query sikertelen. Hiba: " + e.getMessage());
            return null;
        }

    }

    public static final String SELECT_ALL_UGYFEL_ID_QUERY =
            "SELECT id FROM Ugyfel";

    public ArrayList<Integer> Ugyfel_Lekerdezes_Funkcio_UgyfelID() {

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_UGYFEL_ID_QUERY);
            ResultSet results = pstmt.executeQuery();

            ArrayList<Integer> lekert_ugyfelek = new ArrayList<>();
            while (results.next()) {
                QueryUgyfelLekerdezes aktualis_Ugyfel = new QueryUgyfelLekerdezes();
                aktualis_Ugyfel.setAKTUALIS_UGYFEL_ID(results.getInt(1));
                lekert_ugyfelek.add(aktualis_Ugyfel.getAKTUALIS_UGYFEL_ID());
            }
            System.out.println(Arrays.toString(lekert_ugyfelek.toArray()));
            return lekert_ugyfelek;


        } catch (SQLException e) {
            System.out.println("Query sikertelen. Hiba: " + e.getMessage());
            return null;
        }

    }
}

