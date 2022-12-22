package mk.finki.ukim.mk.lab.repository.impl;


import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Bank;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryAtmRepository {

    //treba da vrakja atm
    public List<Bank> findAllAtms(){
        return DataHolder.banks;
    }

}
