package mk.finki.ukim.mk.lab.service.impl;


import mk.finki.ukim.mk.lab.model.Bank;
import mk.finki.ukim.mk.lab.repository.impl.InMemoryBankRepository;
import mk.finki.ukim.mk.lab.service.BankService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankServiceImpl implements BankService {

    private final InMemoryBankRepository bankRepository;

    public BankServiceImpl(InMemoryBankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public Bank findClosestBank(Double lan, Double lon, String name) {

        List<Bank> banks = bankRepository.findAllBanks();

        if(name.equalsIgnoreCase("site")){
            banks = banks.stream()
                    .sorted(
                            Comparator.comparing(b -> Math.abs(lan - b.getLat()) + Math.abs(lon - b.getLon()) )
                    ).collect(Collectors.toList());
            return banks.get(0);
        }

        banks = banks.stream()
                .filter(b -> b.getName().contains(name))
                .collect(Collectors.toList());

        banks = banks.stream()
                .sorted(
                        Comparator.comparing(b -> Math.abs(lan - b.getLat()) + Math.abs(lon - b.getLon()) )
                ).collect(Collectors.toList());



        if (banks.isEmpty())
        {
            return bankRepository.findAllBanks().get(0);
        }

        return banks.get(0);
    }
}
