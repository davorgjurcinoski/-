package mk.finki.ukim.mk.lab.web;


import mk.finki.ukim.mk.lab.model.Atm;
import mk.finki.ukim.mk.lab.service.AtmService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/atms")
public class AtmController {

    private final AtmService atmService;

    public AtmController(AtmService atmService) {
        this.atmService = atmService;
    }

    @PostMapping
    public Atm getClosestAtm(@RequestHeader Double lat,
                               @RequestHeader Double lon,
                               @RequestHeader String atm,
                               HttpServletRequest httpServletRequest) {

        Atm atm1 = this.atmService.findClosestAtm(lat,lon,atm);

        return atm1;
    }

}
