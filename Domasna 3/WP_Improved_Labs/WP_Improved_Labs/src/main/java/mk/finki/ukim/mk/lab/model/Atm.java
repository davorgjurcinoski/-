package mk.finki.ukim.mk.lab.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Atm {

    @Id
    Long id;
    Double lat;
    Double lon;
    String name;

    public Atm(Long id, Double lat, Double lon, String name){
        this.id = id;
        this.lat = lat;
        this.lon = lon;
        this.name = name;
    }

    public Atm(){

    }
}
