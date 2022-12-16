package mk.finki.ukim.mk.lab.model;


import lombok.Data;

@Data
public class Bank {

    Long id;

    Double lat;

    Double lon;

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
