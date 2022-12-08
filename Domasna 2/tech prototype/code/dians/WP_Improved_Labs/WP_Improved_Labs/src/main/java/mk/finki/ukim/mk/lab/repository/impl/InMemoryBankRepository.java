package mk.finki.ukim.mk.lab.repository.impl;


import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Bank;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryBankRepository {

    public List<Bank> findAllBanks(){
        return DataHolder.banks;
    }

}
