package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Atm;
import mk.finki.ukim.mk.lab.model.Bank;

public interface AtmService {

    public Atm findClosestAtm(Double lan, Double lon, String name);
}
