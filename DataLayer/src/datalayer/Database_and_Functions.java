package datalayer;

import common.Ugyfel;
import common.UgyfelTipus;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;

public class Database_and_Functions {

    // Példa a hívásra:

//        Database_and_Functions DB_Muveletek = new Database_and_Functions();
//        // insert new rows
//        DB_Muveletek.insertUgyfel("Úr", "Tibor","Molnár","xy@gmail.com", 22222222,10000, 20000,“2015-01-01”);//

    /**
     * Connect to the Foglalasok.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\db\\Foglalasok.db";
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
                             String telefon, int utolszoSzamla, int osszesSzamla, java.util.Date utolsoLatogatas,
                             String cegNev, String szamlazasiCim, int gyerekekSzama) {

        int id;

        String sql = "INSERT INTO Ugyfel (megszolitas, keresztNev, vezetekNev, email, telefon," +
                " utolsoSzamla, osszesSzamla, utolsoLatogatas, cegNev, szamlazasiCim, gyerekekSzama, ugyfelTipus) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

//        valueOf(String s) : This method converts a string in JDBC date escape format to a Date value using
//        specified value of s- a String object representing a date in the format “yyyy-[m]m-[d]d”.
//        The leading zero for mm and dd may also be omitted.

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, megszolitas);
            pstmt.setString(2, keresztNev);
            pstmt.setString(3, vezetekNev);
            pstmt.setString(4, email);
            pstmt.setString(5, telefon);
            pstmt.setInt(6, utolszoSzamla);
            pstmt.setInt(7, osszesSzamla);
            pstmt.setDate(8, (Date) utolsoLatogatas);
            pstmt.setString(9, cegNev);
            pstmt.setString(10, szamlazasiCim);
            pstmt.setInt(11, gyerekekSzama);
            pstmt.setInt(12, ugyfelTipus.getValue());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
        //To do - key beolvasás ID
        //ugyfel - true átírni, hogy az ügyfélId
        return id;
    }

    public int insertUgyfel(UgyfelTipus ugyfelTipus, String megszolitas, String keresztNev, String vezetekNev, String email,
                             String telefon, int utolszoSzamla, int osszesSzamla, java.util.Date utolsoLatogatas) {
        return insertUgyfel(ugyfelTipus, megszolitas, keresztNev, vezetekNev, email, telefon, utolszoSzamla, osszesSzamla, utolsoLatogatas,
                null, null, 0);


    }

    public int insertUgyfel(UgyfelTipus ugyfelTipus, String megszolitas, String keresztNev, String vezetekNev, String email,
                             String telefon, int utolszoSzamla, int osszesSzamla, java.util.Date utolsoLatogatas,
                             String cegNev, String szamlazasiCim) {
        return insertUgyfel(ugyfelTipus, megszolitas, keresztNev, vezetekNev, email, telefon, utolszoSzamla, osszesSzamla, utolsoLatogatas,
                cegNev, szamlazasiCim, 0);

    }

    public int insertUgyfel(UgyfelTipus ugyfelTipus, String megszolitas, String keresztNev, String vezetekNev, String email,
                             String telefon, int utolszoSzamla, int osszesSzamla, java.util.Date utolsoLatogatas,
                             int gyerekekSzama) {
        return insertUgyfel(ugyfelTipus, megszolitas, keresztNev, vezetekNev, email, telefon, utolszoSzamla, osszesSzamla, utolsoLatogatas,null, null, 0);

    }

    public void insertCegesUgyfel(String cegNev, String szamlazasiCim) {
        String sql = "INSERT INTO CegesUgyfel (cegNev, szamlazasiCim) VALUES(?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cegNev);
            pstmt.setString(2, szamlazasiCim);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertCsaladosUgyfel(int gyerekekSzama) {
        String sql = "INSERT INTO CsaladosUgyfel(gyerekekSzama) VALUES(?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, gyerekekSzama);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertTeremFoglalas(int teremSzam) {
        String sql = "INSERT INTO TeremFoglalas (teremSzam) VALUES(?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, teremSzam);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertAsztalFoglalas(int asztalSzam) {
        String sql = "INSERT INTO AsztalFoglalas (asztalSzam) VALUES(?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, asztalSzam);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertFoglalas(String datum, int szemelyekSzama, String etelallergia,
                               int gyerekekSzama, String megjegyzes) {
        String sql = "INSERT INTO Foglalas (datum, szemelyekSzama, etelallergia, gyerekekSzama, megjegyzes) " +
                "VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDate(1, java.sql.Date.valueOf(datum));
            pstmt.setInt(2, szemelyekSzama);
            pstmt.setString(3, etelallergia);
            pstmt.setInt(4, gyerekekSzama);
            pstmt.setString(5, megjegyzes);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //******************************
    //*******Delete funkciók********

    public void deleteAsztalFoglalas(int asztalSzam) {
        String sql = "DELETE FROM AsztalFoglalas WHERE asztalSzam = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, asztalSzam);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteCegesUgyfel(String cegNev) {
        String sql = "DELETE FROM CegesUgyfel WHERE cegNev = ?";

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

    public void deleteCsaladosUgyfel(int gyerekekSzama) {
        String sql = "DELETE FROM CsaladosUgyfel WHERE gyerekekSzama = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, gyerekekSzama);
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

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //******************************
    //******Update funckciók********

    public void updateAsztalFoglalas(int regi_asztalszam, int uj_asztalSzam) {
        String sql = "UPDATE AsztalFoglalas SET asztalSzam = ? WHERE asztalSzam = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, uj_asztalSzam);
            pstmt.setInt(2, regi_asztalszam);

            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateCegesUgyfel(String regi_cegnev, String cegNev, String szamlazasiCim) {
        String sql = "UPDATE CegesUgyfel SET cegNev = ?, szamlazasiCim = ? WHERE asztalSzam = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, cegNev);
            pstmt.setString(2, szamlazasiCim);
            pstmt.setString(3, regi_cegnev);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateCsaladosUgyfel(int regi_gyerekekSzama, int uj_gyerekekSzama) {
        String sql = "UPDATE CsaladosUgyfel SET gyerekekSzama = ? WHERE gyerekekSzama = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, uj_gyerekekSzama);
            pstmt.setInt(2, regi_gyerekekSzama);

            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateFoglalas(int id, String datum, int szemelyekSzama,
                               String etelallergia, int gyerekekSzama, String megjegyzes) {
        String sql = "UPDATE Foglalas " +
                "SET datum = ?, szemelyekSzama = ?, etelallergia = ?, gyerekekSzama = ?, megjegyzes = ? " +
                "WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setDate(1, java.sql.Date.valueOf(datum));
            pstmt.setInt(2, szemelyekSzama);
            pstmt.setString(3, etelallergia);
            pstmt.setInt(4, gyerekekSzama);
            pstmt.setString(5, megjegyzes);
            pstmt.setInt(6, id);

            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateTeremFoglalas(int regi_teremSzam, int uj_teremSzam) {
        String sql = "UPDATE CsaladosUgyfel SET teremSzam = ? WHERE teremSzam = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, uj_teremSzam);
            pstmt.setInt(2, regi_teremSzam);

            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateUgyfel
            (int id, String megszolitas, String keresztNev, String vezetekNev, String email,
             String telefon, int utolszoSzamla, int osszesSzamla, String utolsoLatogatas) {
        String sql = "UPDATE Foglalas " +
                "SET megszolitas = ?, keresztNev = ?, vezetekNev = ?, email = ?, telefon = ?, " +
                " utolszoSzamla = ?, osszesSzamla = ?, utolsoLatogatas = ?" +
                "WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, megszolitas);
            pstmt.setString(2, keresztNev);
            pstmt.setString(3, vezetekNev);
            pstmt.setString(4, email);
            pstmt.setString(5, telefon);
            pstmt.setInt(6, utolszoSzamla);
            pstmt.setInt(7, osszesSzamla);
            pstmt.setDate(8, java.sql.Date.valueOf(utolsoLatogatas));
            pstmt.setInt(9, id);

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
            "SELECT Ugyfel.id, Ugyfel.megszolitas, Ugyfel.keresztNev, Ugyfel.vezetekNev, "
                    + "Foglalas.id, Foglalas.datum, Foglalas.szemelyekSzama, Foglalas.etelallergia, " +
                    "Foglalas.gyerekekSzama, Foglalas.megjegyzes FROM Ugyfel INNER JOIN Foglalas ON " +
                    "Ugyfel.id = Foglalas.id WHERE Ugyfel.vezeteknev = ?";

    public List<QueryFoglalasLekerdezes> foglalas_Lekerdezes_Funkcio(String vezetekNev) {

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(QUERY_LEKERESFOGLALAS);
            ResultSet results = pstmt.executeQuery();

            List<QueryFoglalasLekerdezes> foglalasok = new ArrayList<>();
            while (results.next()) {
                QueryFoglalasLekerdezes aktualisFoglalas = new QueryFoglalasLekerdezes();
                aktualisFoglalas.setUGYFEL_MEGSZOLITAS_QUERY(results.getString(1));
                aktualisFoglalas.setUGYFEL_KERESZTNEV_QUERY(results.getString(2));
                aktualisFoglalas.setUGYFEL_VEZETEKNEV_QUERY(results.getString(3));
                aktualisFoglalas.setFOGLALAS_ID_QUERY(results.getInt(4));
                aktualisFoglalas.setFOGLALAS_DATUM_QUERY(results.getString(5));
                aktualisFoglalas.setFOGLALAS_SZEMELYEKSZAMA_QUERY(results.getInt(6));
                aktualisFoglalas.setFOGLALAS_ETELALLERGIA_QUERY(results.getString(7));
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
            "SELECT Ugyfel.id, Ugyfel.megszolitas, Ugyfel.keresztNev, Ugyfel.vezetekNev, " +
                    "Ugyfel.email, Ugyfel.telefon " +
                    "FROM Ugyfel WHERE Ugyfel.vezeteknev = ?";

    public List<QueryUgyfelLekerdezes> Ugyfel_Lekerdezes_Funkcio(String vezetekNev) {

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(SELECT_UGYFEL_QUERY);
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

}
