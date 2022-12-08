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

    Bank bank1 = new Bank((long) 1,41.9936657,21.4428736,"НБРМ");
    Bank bank2 = new Bank((long) 2,42.0073792,21.3682515,"Stopanska banka");
    Bank bank3 = new Bank((long) 3,41.9876902,21.4327574,"Стопанска Банка");


   }
}
