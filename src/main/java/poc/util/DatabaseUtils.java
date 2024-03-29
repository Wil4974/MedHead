package poc.util;

import poc.model.Hospital;
import poc.model.Speciality;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtils {

    public static List<Speciality> ConnectToGetSpecialitiesDatas () {

        List<Speciality> allSpecialities = new ArrayList<>();

        try
        {
            Class.forName("org.postgresql.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/medhead",
                    "wil",
                    "wil");

            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT id, name FROM speciality");

            while(res.next())
                allSpecialities.add(new Speciality(res.getInt(1), res.getString(2)));

            conn.close();

        }
        catch(Exception e){
            System.out.println(e);
        }
        return allSpecialities;
    }

    public static List<Hospital> ConnectToGetHospitalsWithSpecialitiesDatas () {

        List<Hospital> allHospitals = new ArrayList<>();

        try
        {
            Class.forName("org.postgresql.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/medhead","wil","wil");

            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT h.id, h.name, latitude, longitude, availableBeds, hs.specialityId FROM hospital h, hospitalSpecialities hs WHERE h.id = hs.hospitalId");

            while(res.next())
                allHospitals.add(new Hospital(res.getInt(1), res.getString(2), res.getDouble(3), res.getDouble(4), res.getInt(5), res.getString(6)));

            conn.close();

        }
        catch(Exception e){
            System.out.println(e);
        }
        return allHospitals;
    }

    public static List<Hospital> ConnectToGetHospitalsDatas () {

        List<Hospital> allHospitals = new ArrayList<>();

        try
        {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/medhead","wil","wil");

            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("select h.id, h.name, latitude, longitude, availableBeds from hospital h");

            while(res.next())
                allHospitals.add(new Hospital(res.getInt(1),
                        res.getString(2),
                        res.getDouble(3),
                        res.getDouble(4),
                        res.getInt(5)));

            conn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return allHospitals;
    }

    public static String AddReservation (String hospitalName) {
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/medhead","wil","wil");

            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("INSERT INTO reservation VALUES(" + hospitalName + "; ");

            String sql = "INSERT INTO reservation (hopsitalName) VALUES('" + hospitalName + "'); ";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, hospitalName);

            int rowsInserted = statement.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return ("Hôpital " + hospitalName + " a bien reçu votre réservation de lit.");
    }
}
