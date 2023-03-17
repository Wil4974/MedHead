package poc.util;

import poc.model.Hospital;
import poc.model.Speciality;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectToPostgreSQL {

    public static List<Speciality> ToGetSpecialitiesDatas () {

        List<Speciality> allSpecialities = new ArrayList<>();

        try
        {
            //étape 1: charger la classe de driver
            Class.forName("org.postgresql.Driver");

            //étape 2: créer l'objet de connexion
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/medhead_poc","wil","wil");

            //étape 3: créer l'objet statement
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM speciality");

            //étape 4: exécuter la requête
            while(res.next())
                allSpecialities.add(new Speciality(res.getInt(1), res.getString(2)));

            //étape 5: fermez l'objet de connexion
            conn.close();

        }
        catch(Exception e){
            System.out.println(e);
        }
        return allSpecialities;
    }

    public static List<Hospital> ToGetHospitalsWithSpecialitiesDatas () {

        List<Hospital> allHospitals = new ArrayList<>();

        try
        {
            //étape 1: charger la classe de driver
            Class.forName("org.postgresql.Driver");

            //étape 2: créer l'objet de connexion
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/medhead_poc","wil","wil");

            //étape 3: créer l'objet statement
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("select h.id, h.name, latitude, longitude, available_beds, hs.speciality_id  from hospital h, hospital_specialities hs WHERE h.id = hs.hospital_id");

            //étape 4: exécuter la requête
            while(res.next())
                allHospitals.add(new Hospital(res.getInt(1), res.getString(2), res.getDouble(3), res.getDouble(4), res.getInt(5), res.getString(6)));

            //étape 5: fermez l'objet de connexion
            conn.close();

        }
        catch(Exception e){
            System.out.println(e);
        }
        return allHospitals;
    }

    public static List<Hospital> ToGetHospitalsDatas () {

        List<Hospital> allHospitals = new ArrayList<>();

        try
        {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/medhead_poc","wil","wil");

            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("select h.id, h.name, latitude, longitude, available_beds from hospital h");

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
}
