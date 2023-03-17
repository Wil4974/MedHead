package poc.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Speciality")
public class Speciality {

    @Id
    @GeneratedValue
    private int id;

    @Column(length = 50, nullable = false)
    private String name;

    public Speciality(){
        super();
    };
    public Speciality(String name){
        super();
        this.name = name;
    };

    public Speciality(int id, String name){
        super();
        this.id = id;
        this.name = name;
    };
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
