package mk.finki.ukim.mk.lab.service.impl;


import mk.finki.ukim.mk.lab.model.Bank;
import mk.finki.ukim.mk.lab.repository.impl.InMemoryAtmRepository;
import mk.finki.ukim.mk.lab.service.AtmService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtmServiceImpl implements AtmService {

    private final InMemoryAtmRepository atmRepository;

    public AtmServiceImpl(InMemoryAtmRepository atmRepository) {
        this.atmRepository = atmRepository;
    }

    @Override
    public Bank findClosestAtm(Double lan, Double lon, String name) {

        List<Bank> atms = atmRepository.findAllAtms();


        if(name.equals("Site")){
            atms = atms.stream()
                    .sorted(
                            Comparator.comparing(b -> Math.abs(lan - b.getLat()) + Math.abs(lon - b.getLon()) )
                    ).collect(Collectors.toList());
            return atms.get(0);
        }


        atms = atms.stream()
                .filter(b -> b.getName().contains(name))
                .collect(Collectors.toList());

        atms = atms.stream()
                .sorted(
                        Comparator.comparing(b -> Math.abs(lan - b.getLat()) + Math.abs(lon - b.getLon()) )
                ).collect(Collectors.toList());



        if (atms.isEmpty())
        {
            return atmRepository.findAllAtms().get(0);
        }

        return atms.get(0);
    }
}
