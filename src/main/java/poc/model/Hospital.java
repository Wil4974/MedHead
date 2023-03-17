package poc.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Hospital")
public class Hospital{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50)
    private String name;
    private double latitude;
    private double longitude;
    private int availableBeds;

    private String specialities;

    public Hospital(){}
    public Hospital(int id, String name, double latitude, double longitude, int availableBeds, String specialities) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.availableBeds = availableBeds;
        this.specialities = specialities;
    }

    public Hospital(int id, String name, double latitude, double longitude, int availableBeds) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.availableBeds = availableBeds;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getAvailableBeds() {
        return availableBeds;
    }
    public void setAvailableBeds(int availableBeds) {
        this.availableBeds = availableBeds;
    }

    @ManyToOne
    @JoinColumn(name = "Speciality.Id")
    public String getSpecialities() {
        return specialities;
    }
    public void setSpecialities(String specialities) {
        this.specialities = specialities;
    }
}
