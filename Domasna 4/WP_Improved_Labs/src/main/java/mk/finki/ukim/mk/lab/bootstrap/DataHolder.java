package mk.finki.ukim.mk.lab.bootstrap;

import mk.finki.ukim.mk.lab.model.Bank;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Bank> banks = new ArrayList<>();



    @PostConstruct
    public void init() {

    Bank bank1 = new Bank((long) 1,41.9936657,21.4428736,"Narodna");
    Bank bank2 = new Bank((long) 2,42.0073792,21.3682515,"Stopanska banka");
    Bank bank3 = new Bank((long) 3,41.9876902,21.4327574,"Stopanska banka");
    Bank bank4 = new Bank((long) 1,42.0043009,21.3847909	,"Unibank");

        Bank bank5 = new Bank((long) 1,42.0304003,21.4447546	,"NLB");
        Bank bank6 = new Bank((long) 1,41.9866114,21.4633707	,"Komercijalna");
        Bank bank7 = new Bank((long) 1,42.000144,21.459307	,"Sparkasse");
        Bank bank8 = new Bank((long) 1,41.992781,21.4254378	,"NLB");

    banks.add(bank1);
    banks.add(bank2);
    banks.add(bank3);
    banks.add(bank4);
        banks.add(bank5);
        banks.add(bank6);
        banks.add(bank7);
        banks.add(bank8);


   }
}
