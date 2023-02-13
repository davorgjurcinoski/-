package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Atm;

public interface AtmService {

    public Atm findClosestAtm(Double lan, Double lon, String name);
}
