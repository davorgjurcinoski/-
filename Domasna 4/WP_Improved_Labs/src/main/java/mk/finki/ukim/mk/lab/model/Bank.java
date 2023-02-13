package mk.finki.ukim.mk.lab.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Bank {

    @Id
    Long id;

    Double lat;

    Double lon;

    @Column(name = "name_banks")
    String name;


    public Bank(Long id, Double lat, Double lon, String name) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
        this.name = name;
    }

    public Bank() {
    }


}
