package mk.finki.ukim.mk.lab.service.impl;


import mk.finki.ukim.mk.lab.model.Bank;
import mk.finki.ukim.mk.lab.repository.impl.BankRepository;
import mk.finki.ukim.mk.lab.service.BankService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankServiceImpl implements BankService {


    private final BankRepository bankRepositories;

    public BankServiceImpl(BankRepository bankRepositories) {
        this.bankRepositories = bankRepositories;
    }

    @Override
    public Bank findClosestBank(Double lan, Double lon, String name) {

        List<Bank> banks = bankRepositories.findAll();

        if (name.equalsIgnoreCase("site")) {
            banks = banks.stream()
                    .sorted(
                            Comparator.comparing(b -> Math.abs(lan - b.getLat()) + Math.abs(lon - b.getLon()))
                    ).collect(Collectors.toList());
            return banks.get(0);
        }

        banks = banks.stream()
                .filter(b -> b.getName().contains(name))
                .collect(Collectors.toList());

        banks = banks.stream()
                .sorted(
                        Comparator.comparing(b -> Math.abs(lan - b.getLat()) + Math.abs(lon - b.getLon()))
                ).collect(Collectors.toList());


        if (banks.isEmpty()) {
            return bankRepositories.findAll().get(0);
        }

        return banks.get(0);
    }
}
