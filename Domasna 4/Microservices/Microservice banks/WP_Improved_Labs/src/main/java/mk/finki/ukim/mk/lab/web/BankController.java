package mk.finki.ukim.mk.lab.web;


import mk.finki.ukim.mk.lab.model.Bank;
import mk.finki.ukim.mk.lab.service.BankService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/banks")
public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping
    @ResponseBody
    public Bank getClosestBank(@RequestHeader Double lat,
                         @RequestHeader Double lon,
                         @RequestHeader String banka,
                         HttpServletRequest servletRequest) {
        Bank bank = bankService.findClosestBank(lat, lon, banka);
        return bank;
    }
}
