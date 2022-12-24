package mk.finki.ukim.mk.lab.web;


import com.sun.net.httpserver.HttpServer;
import mk.finki.ukim.mk.lab.model.Bank;
import mk.finki.ukim.mk.lab.service.BankService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("map/{banka}")
public class MapController {

    private final BankService bankService;

    public MapController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping
    public String getLoginPage(@PathVariable String banka, Model model, HttpServletRequest httpServletRequest) {

        //funkcionira
        Double myLat = (double) httpServletRequest.getSession().getAttribute("lat");
        Double muLon = (double) httpServletRequest.getSession().getAttribute("lon");;

        Bank bank = bankService.findClosestBank(myLat,muLon,banka);

        Double bankLat = bank.getLat();
        Double bankLon = bank.getLon();
        model.addAttribute("lat", bankLat);
        model.addAttribute("lon", bankLon);



        if(!bank.getName().equalsIgnoreCase("site")){
            model.addAttribute("imeBanka", bank.getName());
        }
        else {
            model.addAttribute("imeBanka", "банка");
        }




        //hardcode bug fix
        if (myLat == 123456){
            return "home";
        }


        return "mapa";
    }

}
