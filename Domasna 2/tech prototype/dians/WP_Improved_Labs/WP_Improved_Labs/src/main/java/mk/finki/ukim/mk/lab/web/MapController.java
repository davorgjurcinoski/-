package mk.finki.ukim.mk.lab.web;


import mk.finki.ukim.mk.lab.model.Bank;
import mk.finki.ukim.mk.lab.service.BankService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("map/{banka}")
public class MapController {

    private final BankService bankService;

    public MapController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping
    public String getLoginPage(@PathVariable String banka, Model model) {

//        Double myLat = 42.0073792;
//        Double muLon = 21.3682515;
//        Bank bank = bankService.findClosestBank(myLat,muLon,banka);
//        Double bankLat = bank.getLat();
//        Double bankLon = bank.getLon();
//        model.addAttribute("lat", bankLat);
//        model.addAttribute("lon", bankLon);


        model.addAttribute("lat", 42.0073792);
        model.addAttribute("lon", 21.3682515);


        return "mapa";
    }

}
