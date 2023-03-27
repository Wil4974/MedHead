package poc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Hospital")
@AllArgsConstructor
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50)
    private String name;
    private double latitude;
    private double longitude;
    private int availableBeds;

    @ManyToMany
    @JoinTable(
            name = "hospital_specialities",
            joinColumns = @JoinColumn(name = "hospital_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id")
    )
    private List<Speciality> specialities;

    public Hospital() {
    }

    public Hospital(int id, String name, double latitude, double longitude, int availableBeds) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.availableBeds = availableBeds;
        this.specialities = new ArrayList<>();
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

    public double getLongitude() {
        return longitude;
    }

    public int getAvailableBeds() {
        return availableBeds;
    }

    @ManyToOne
    @JoinColumn(name = "Speciality.Id")
    public List<Speciality> getSpecialities() {
        return specialities;
    }
}