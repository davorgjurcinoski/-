package mk.finki.ukim.mk.lab.web;



import mk.finki.ukim.mk.lab.model.Atm;
import mk.finki.ukim.mk.lab.model.Bank;
import mk.finki.ukim.mk.lab.service.AtmService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("mapAtm/{bankomat}")
public class MapAtmController {

    private final AtmService atmService;

    public MapAtmController(AtmService atmService) {
        this.atmService = atmService;
    }

    @GetMapping
    public String getLoginPage(@PathVariable String bankomat, Model model, HttpServletRequest httpServletRequest) {

        if (httpServletRequest.getSession().getAttribute("lat") == null) return "home";
        //funkcionira
        Double myLat = (double) httpServletRequest.getSession().getAttribute("lat");
        Double muLon = (double) httpServletRequest.getSession().getAttribute("lon");

        model.addAttribute("myLat", myLat);
        model.addAttribute("muLon", muLon);

        httpServletRequest.getSession().removeAttribute("lat");
        httpServletRequest.getSession().removeAttribute("lon");
        httpServletRequest.getSession().invalidate();

        Atm atm = atmService.findClosestAtm(myLat,muLon,bankomat);

        Double bankLat = atm.getLat();
        Double bankLon = atm.getLon();
        model.addAttribute("lat", bankLat);
        model.addAttribute("lon", bankLon);

        if(!atm.getName().equalsIgnoreCase("site")){
            model.addAttribute("imeBanka", atm.getName());
        }
        else {
            model.addAttribute("imeBanka", "банкомат");
        }




        //hardcode bug fix
        if (myLat == 123456){
            return "home";
        }


        return "mapa";
    }

}
