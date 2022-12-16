package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Bank;

public interface AtmService {

    public Bank findClosestBank (Double lan, Double lon, String name);
}
