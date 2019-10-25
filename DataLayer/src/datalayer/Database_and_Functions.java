package datalayer;

// Ebben az osztályban a következők találhatók:
//- adatbázis elérési útja
//- a kapcsolat nyitása az adatbázishoz
//- a különböző methódusok, amik az adatbázishoz kellenek

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database_and_Functions {

    //A változó amivel bárhol hivatkozhatunk az adatbázis nevére
    public static final String DB_NAME = "Foglalasok.db";

    //Az elérési út, ahol az adatbázisunk található
    //jdbc:sqlite: rész kötelező
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\db\\" + DB_NAME;

    //    A rendezéshez használt változók
    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;

    //------------------------------------------------------------------------------------------------------------------
    //Változók, amikre hivatkozunk a query-kben
    //Egy változó minden táblának és tábla mezőnek

    //Felépítés: SQL object neve - Tábla neve - Mező neve

    public static final String TABLE_ASZTALFOGLALAS = "AsztalFoglalas";
    public static final String COLUMN_ASZTALFOGLALAS_ASZTALSZAM = "asztalSzam";

    public static final String TABLE_CEGESUGYFEL = "CegesUgyfel";
    public static final String COLUMN_CEGESUGYFEL_CEGNEV = "cegNev";
    public static final String COLUMN_CEGESUGYFEL_SZAMLAZASI_CIM = "szamlazasiCim";

    public static final String TABLE_CSALADOSUGYFEL = "CsaladosUgyfel";
    public static final String COLUMN_CSALADOSUGYFEL_GYEREKEKSZAMA = "gyerekekSzama";

    public static final String TABLE_FOGLALAS = "Foglalas";
    public static final String COLUMN_FOGLALAS_ID = "id";
    public static final String COLUMN_FOGLALAS_DATUM = "datum";
    public static final String COLUMN_FOGLALAS_SZEMELYEKSZAMA = "szemelyekSzama";
    public static final String COLUMN_FOGLALAS_ETELALLERGIA = "etelallergia";
    public static final String COLUMN_FOGLALAS_GYEREKEKSZAMA = "gyerekekSzama";
    public static final String COLUMN_FOGLALAS_MEGJEGYZES = "megjegyzes";

    public static final String TABLE_TEREMFOGLALAS = "TetemFoglalas";
    public static final String COLUMN_TEREMFOGLALAS_TEREMSZAM = "teremSzam";

    public static final String TABLE_UGYFEL = "Ugyfel";
    public static final String COLUMN_UGYFEL_ID = "id";
    public static final String COLUMN_UGYFEL_MEGSZOLITAS = "megszolitas";
    public static final String COLUMN_UGYFEL_KERESZTNEV = "keresztNev";
    public static final String COLUMN_UGYFEL_VEZETEKNEV = "vezetekNev";
    public static final String COLUMN_UGYFEL_EMAIL = "email";
    public static final String COLUMN_UGYFEL_TELEFON = "telefon";
    public static final String COLUMN_UGYFEL_UTOLSOSZAMLA = "utolsoSzamla";
    public static final String COLUMN_UGYFEL_OSSZESSZAMLA = "osszesSzamla";
    public static final String COLUMN_UGYFEL_UTOLSOLATOGATAS = "utolsoLatogatas";

    //------------------------------------------------------------------------------------------------------------------
    //Queries, ide jönnek az SQL Query-ik amiket, a Prepared statement-en keresztül küldünk

    //Lekérdezés Query

    public static final String QUERY_LEKERESFOGLALAS =
            "SELECT "
                    + TABLE_UGYFEL + "." + COLUMN_UGYFEL_ID + ", "
                    + TABLE_UGYFEL + "." + COLUMN_UGYFEL_MEGSZOLITAS + ", "
                    + TABLE_UGYFEL + "." + COLUMN_UGYFEL_KERESZTNEV + ", "
                    + TABLE_UGYFEL + "." + COLUMN_UGYFEL_VEZETEKNEV + ", "
                    + TABLE_FOGLALAS + "." + COLUMN_FOGLALAS_ID + ", "
                    + TABLE_FOGLALAS + "." + COLUMN_FOGLALAS_DATUM + ", "
                    + TABLE_FOGLALAS + "." + COLUMN_FOGLALAS_SZEMELYEKSZAMA + ", "
                    + TABLE_FOGLALAS + "." + COLUMN_FOGLALAS_ETELALLERGIA + ", "
                    + TABLE_FOGLALAS + "." + COLUMN_FOGLALAS_GYEREKEKSZAMA + ", "
                    + TABLE_FOGLALAS + "." + COLUMN_FOGLALAS_MEGJEGYZES + ", "
                    + " FROM "
                    + TABLE_UGYFEL + " "
                    + " INNER JOIN "
                    + TABLE_FOGLALAS + " ON "
                    + TABLE_UGYFEL + "." + COLUMN_UGYFEL_ID + " = " + TABLE_FOGLALAS + "." + COLUMN_FOGLALAS_ID
                    + " WHERE " + COLUMN_UGYFEL_VEZETEKNEV + " = ?";

    //Insert Query

    //Az elmélet az, hogy a funkcióban, minden táblára futtatunk egy query-t egymás után,
    //ezt lehetne elegánsabban, de már alig látok és haladni kellene
    //Minden táblára található itt egy INSERT_INTO query

    public static final String QUERY_INSERT_INTO_ASZTALFOGLALAS =
            "INSERT INTO " + TABLE_ASZTALFOGLALAS +
                    '(' + COLUMN_ASZTALFOGLALAS_ASZTALSZAM +
                    ") VALUES(?)";

    public static final String QUERY_INSERT_INTO_CEGESUGYFEL =
            "INSERT INTO " + TABLE_CEGESUGYFEL +
                    '(' + COLUMN_CEGESUGYFEL_CEGNEV + ", "
                    + COLUMN_CEGESUGYFEL_SZAMLAZASI_CIM + ") +" +
                    "VALUES (?,?)";

    public static final String QUERY_INSERT_INTO_CSALADOSUGYFEL =
            "INSERT INTO " + TABLE_CSALADOSUGYFEL +
                    '(' + COLUMN_CSALADOSUGYFEL_GYEREKEKSZAMA +
                    ") VALUES (?)";

    public static final String QUERY_INSERT_INTO_FOGLALAS =
            "INSERT INTO " + TABLE_FOGLALAS
                    + '(' + COLUMN_FOGLALAS_ID + ", "
                    + '(' + COLUMN_FOGLALAS_DATUM + ", "
                    + '(' + COLUMN_FOGLALAS_SZEMELYEKSZAMA + ", "
                    + '(' + COLUMN_FOGLALAS_ETELALLERGIA + ", "
                    + '(' + COLUMN_FOGLALAS_GYEREKEKSZAMA + ", "
                    + COLUMN_FOGLALAS_MEGJEGYZES + ") +" +
                    "VALUES (?,?,?,?,?)";

    public static final String QUERY_INSERT_INTO_TEREMFOGLALAS =
            "INSERT INTO " + TABLE_TEREMFOGLALAS +
                    '(' + COLUMN_TEREMFOGLALAS_TEREMSZAM +
                    ") VALUES(?)";

    public static final String QUERY_INSERT_INTO_UGYFEL =
            "INSERT INTO " + TABLE_UGYFEL
                    + '(' + COLUMN_UGYFEL_MEGSZOLITAS + ", "
                    + '(' + COLUMN_UGYFEL_KERESZTNEV + ", "
                    + '(' + COLUMN_UGYFEL_VEZETEKNEV + ", "
                    + '(' + COLUMN_UGYFEL_EMAIL + ", "
                    + '(' + COLUMN_UGYFEL_TELEFON + ", "
                    + '(' + COLUMN_UGYFEL_UTOLSOSZAMLA + ", "
                    + '(' + COLUMN_UGYFEL_OSSZESSZAMLA + ", "
                    + COLUMN_UGYFEL_UTOLSOLATOGATAS + ") +" +
                    "VALUES (?,?,?,?,?,?,?)";


    //------------------------------------------------------------------------------------------------------------------
    // Prepared Statements:
    // Ezekkel az előre elkészített Statament-ekkel védekezünk SQL injection attack ellen
    // A Preparedstaement a Connection osztály, conn példányát fogja használni arra,
    // hogy lefuttassa a query-ket

//    Jelenleg a táblák külön vannak
//    Külön kell őket updatelni

    private PreparedStatement rogzitesAllergia;
    private PreparedStatement rogzitesAsztalFoglalas;
    private PreparedStatement rogzitesCegesUgyfel;
    private PreparedStatement rogzitesCsaladosUgyfel;
    private PreparedStatement rogzitesFoglalas;
    private PreparedStatement rogzitesTeremFoglalas;
    private PreparedStatement rogzitesUgyfel;


    private PreparedStatement lekeresFoglalas;

    private PreparedStatement frissitesFoglalas;

    private PreparedStatement torlesFoglalas;

    //------------------------------------------------------------------------------------------------------------------
    //    A connection osztály egy példánya, amivel elérjük a db-t
    private Connection conn;

    //------------------------------------------------------------------------------------------------------------------
    //    Megpróbálunk kapcsolódni, a db-hez, error-t dob, ha nem sikerül
    //    Ide illesztjük a PreparedStatement-ket, amik futtatják a Query-t
    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);


            // DB Adatfelvétel

            rogzitesAllergia = conn.prepareStatement("ide jönnek a Query-k, ha elkészültek");
            rogzitesAsztalFoglalas = conn.prepareStatement(QUERY_INSERT_INTO_ASZTALFOGLALAS);
            rogzitesCegesUgyfel = conn.prepareStatement(QUERY_INSERT_INTO_CEGESUGYFEL);
            rogzitesCsaladosUgyfel = conn.prepareStatement(QUERY_INSERT_INTO_CSALADOSUGYFEL);
            rogzitesFoglalas = conn.prepareStatement(QUERY_INSERT_INTO_FOGLALAS);
            rogzitesTeremFoglalas = conn.prepareStatement(QUERY_INSERT_INTO_TEREMFOGLALAS);
            rogzitesUgyfel = conn.prepareStatement(QUERY_INSERT_INTO_UGYFEL);

            // DB módosítás
            frissitesFoglalas = conn.prepareStatement("ide jönnek a Query-k, ha elkészültek");
            torlesFoglalas = conn.prepareStatement("ide jönnek a Query-k, ha elkészültek");

            // DB lekérdezés
            lekeresFoglalas = conn.prepareStatement(QUERY_LEKERESFOGLALAS);


            return true;

        } catch (SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    //    A kapcsolatokat bontanunk kell, ha végeztünk a DB-vel
    //    Ez történik itt

    //      !! A conn példányt kell utoljára zárni, javítva
    public void close() {
        try {

            if (rogzitesAllergia != null) {
                rogzitesAllergia.close();
            }

            if (rogzitesAsztalFoglalas != null) {
                rogzitesAsztalFoglalas.close();
            }

            if (rogzitesCegesUgyfel != null) {
                rogzitesCegesUgyfel.close();
            }

            if (rogzitesCsaladosUgyfel != null) {
                rogzitesCsaladosUgyfel.close();
            }

            if (rogzitesFoglalas != null) {
                rogzitesFoglalas.close();
            }

            if (rogzitesTeremFoglalas != null) {
                rogzitesTeremFoglalas.close();
            }

            if (rogzitesUgyfel != null) {
                rogzitesUgyfel.close();
            }

            if (lekeresFoglalas != null) {
                lekeresFoglalas.close();
            }

            if (conn != null) {
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }

    }
    //</editor-fold>
//    //--------------------------------------------------------------------------------------------------
//    // Protecting agains SQL Injection attack takes too much time, time for simple querries
//
////    We want to retrive data with an SQL query
//
////    First, let's build the query that can be used to dynamically retrieve information
////    Query needs to be modified for each table, let's create the basic select all queries
//
////    Example:
////    public static final String QUERY_ALBUMS_BY_ARTIST_START =
////            "SELECT " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_NAME + " FROM " + TABLE_ALBUMS +
////                    " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST +
////                    " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID +
////                    " WHERE " + TABLE_ARTISTS + "." + COLUMN_ALBUM_NAME + " = \"";
//
//
//
//
////    Basic queries:
//
//    //    Select all from a table:
//    public static final String SELECT_ALL_FROM_ASZTALFOGLALAS =
//            "SELECT * FROM " + TABLE_ASZTALFOGLALAS;
//
////    Select all UGYFEL JOINED ON FOGLALAS:
////    First, we prepare the SQL Statement, the ? mark, is for later
//    public static final String UGYFEL_FOGLALAS =
//            "SELECT "
//                    + TABLE_UGYFEL + "." + COLUMN_UGYFEL_ID + ", "
//                    + TABLE_UGYFEL + "." + COLUMN_UGYFEL_MEGSZOLITAS + ", "
//                    + TABLE_UGYFEL + "." + COLUMN_UGYFEL_KERESZTNEV + ", "
//                    + TABLE_UGYFEL + "." + COLUMN_UGYFEL_VEZETEKNEV + ", "
//                    + TABLE_FOGLALAS + "." + COLUMN_FOGLALAS_ID + ", "
//                    + TABLE_FOGLALAS + "." + COLUMN_FOGLALAS_DATUM + ", "
//                    + TABLE_FOGLALAS + "." + COLUMN_FOGLALAS_SZEMELYEKSZAMA + ", "
//                    + TABLE_FOGLALAS + "." + COLUMN_FOGLALAS_ETELALLERGIA + ", "
//                    + TABLE_FOGLALAS + "." + COLUMN_FOGLALAS_GYEREKEKSZAMA + ", "
//                    + TABLE_FOGLALAS + "." + COLUMN_FOGLALAS_MEGJEGYZES + ", "
//                    + " FROM "
//                    + TABLE_UGYFEL + " "
//                    + " INNER JOIN "
//                    + TABLE_FOGLALAS + " ON "
//                    + TABLE_UGYFEL + "." + COLUMN_UGYFEL_ID + " = " + TABLE_FOGLALAS + "." + COLUMN_FOGLALAS_ID
//                    + " WHERE " + COLUMN_UGYFEL_VEZETEKNEV + " = ?";
//
////     We create a private Preparedstatement, to defend against SQL Injection attacks
//
//    private PreparedStatement UGYFEL_FOGLALAS_VIEW;
//
//    // We feed this into the try above on line 69
//
//    //-------------------------------------------------------------------------------------------------- **/

//        Find and write out to Console:

//    public List<String> queryFoglalas(String vezetekNev, int sortOrder) {
//
//        StringBuilder sb = new StringBuilder(QUERY_FOGLALAS);
//        sb.append(vezetekNev);
//        sb.append("\"");
//
//        if (sortOrder != ORDER_BY_NONE) {
//
//            sb.append(" ORDER BY ");
//            sb.append(TABLE_UGYFEL);
//            sb.append('.');
//            sb.append(COLUMN_UGYFEL_ID);
//            sb.append(" COLLATE NOCASE ");
//
//            if (sortOrder == ORDER_BY_DESC) {
//                sb.append("DESC");
//            } else {
//                sb.append("ASC");
//            }
//
//        }
//
//        System.out.println("SQL statement = " + sb.toString());
//
//        try (Statement statement = conn.createStatement();
//             ResultSet results = statement.executeQuery(sb.toString())) {
//
//            List<String> foglalasok = new ArrayList<>();
//            while (results.next()) {
//                foglalasok.add(results.getString(1));
//                foglalasok.add(results.getString(2));
//                foglalasok.add(results.getString(3));
//                foglalasok.add(results.getString(4));
//                foglalasok.add(results.getString(5));
//                foglalasok.add(results.getString(6));
//                foglalasok.add(results.getString(7));
//                foglalasok.add(results.getString(8));
//                foglalasok.add(results.getString(9));
//                foglalasok.add(results.getString(10));
//            }
//
//            return foglalasok;
//
//        } catch (SQLException e) {
//            System.out.println("Query failed: " + e.getMessage());
//            return null;
//        }
//    }

    //------------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------------------------------------





    //Lekérés funkció:

    // ***************************
    //**********Funkciók**********
    // ***************************


    public List<QueryFoglalasLekerdezes> foglalas_Lekerdezes_Funkcio(String vezetekNev) {

        //Ez a funkció megpróbálja futtatni, a query-t, ami a prepared-statement-hez kapcsolt,
        //ha nem sikerül a query-t futtatni, kapunk egy hibaüzenetet a konzolra

        //Híváskor, kéri a vezetéknevét a foglalónak
        //Létrehoz egy tömböt, a QueryFoglalasLekerdezes osztály alapján,
        //ahova betudja tárolni a lekérdezésben szereplő mezőket
        //egy Resultset-be lementi a lekérdezés eredményét,
        //majd létrehoz egy QueryFoglalasLekerdezes tömböt,
        //amit feltölti a lenti set módszerekkel, amik van következő eredmény a resulset-ben

        try {
            lekeresFoglalas.setString(1, vezetekNev);
            ResultSet results = lekeresFoglalas.executeQuery();

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
            return foglalasok;

        } catch (SQLException e) {
            System.out.println("Query sikertelen. Hiba: " + e.getMessage());
            return null;
        }

        //A kiiratás-t még meg kell oldani!

//    System.out.println("A foglalások " + vezetekNev + " név alatt a következők: ");
//        System.out.println("--------------");
//
//        for (int i = 0; i < list.size(); i++) {
//        System.out.println(list.get(i));

    }

    //Insert into funkciók:

    private void asztalFoglalas(int asztalSzam) throws SQLException {

        rogzitesAsztalFoglalas.setInt(1, asztalSzam);
        int erintettSorok = rogzitesAsztalFoglalas.executeUpdate();

        if (erintettSorok != 1) {
            throw new SQLException("Nem tudtam beilleszteni az asztalfoglalást!");
        }
    }

    private void cegesUgyfel(String cegNev, String szamlazasiCim) throws SQLException {

        rogzitesCegesUgyfel.setString(1, cegNev);
        rogzitesCegesUgyfel.setString(2, szamlazasiCim);
        int erintettSorok = rogzitesCegesUgyfel.executeUpdate();

        if (erintettSorok != 1) {
            throw new SQLException("Nem tudtam beilleszteni a céges ügyfelet!");
        }
    }

    private void csaladosUgyfel(int gyerekekSzama) throws SQLException {

        rogzitesCsaladosUgyfel.setInt(1, gyerekekSzama);
        int erintettSorok = rogzitesCsaladosUgyfel.executeUpdate();

        if (erintettSorok != 1) {
            throw new SQLException("Nem tudtam beilleszteni a családos ügyfelet!");
        }
    }

    private void foglalas(Date datum, int szemelyekSzama, String etelallergia, int gyerekekSzama, String megjegyzes) throws SQLException {

        //2. oszloppal kezdünk a feltöltésnél, mert az első oszlop ID, auto increment-es
        rogzitesFoglalas.setDate(2, datum);
        rogzitesFoglalas.setInt(3, szemelyekSzama);
        rogzitesFoglalas.setString(4, etelallergia);
        rogzitesFoglalas.setInt(5, gyerekekSzama);
        rogzitesFoglalas.setString(6, megjegyzes);

        int erintettSorok = rogzitesFoglalas.executeUpdate();

        if (erintettSorok != 1) {
            throw new SQLException("Nem tudtam beilleszteni foglalás!");
        }
    }

    private void teremFoglalas(int teremSzam) throws SQLException {

        rogzitesTeremFoglalas.setInt(1, teremSzam);
        int erintettSorok = rogzitesTeremFoglalas.executeUpdate();

        if (erintettSorok != 1) {
            throw new SQLException("Nem tudtam beilleszteni teremfoglalást!");
        }
    }

    private void ugyfel(String megszolitas, String keresztNev, String vezetekNev, String email,
                        int telefon, int utolsoSzamla, int osszesSzamla, Date utolsoLatogatas)
            throws SQLException {
        //Első mező ügyfél ID, auto increment mező
        rogzitesUgyfel.setString(2, megszolitas);
        rogzitesUgyfel.setString(3, keresztNev);
        rogzitesUgyfel.setString(4, vezetekNev);
        rogzitesUgyfel.setString(5, email);
        rogzitesUgyfel.setInt(6, telefon);
        rogzitesUgyfel.setInt(7, utolsoSzamla);
        rogzitesUgyfel.setInt(8, osszesSzamla);
        rogzitesUgyfel.setDate(9, utolsoLatogatas);
        int erintettSorok = rogzitesUgyfel.executeUpdate();

        if (erintettSorok != 1) {
            throw new SQLException("Nem tudtam beilleszteni az ügyfelet!");
        }
    }

}