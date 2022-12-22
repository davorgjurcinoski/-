package mk.finki.ukim.mk.lab.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("banks")

public class BankController {

    @GetMapping
    public String banki() {
        return "banki";
    }

    @PostMapping
    public String getBanks(@RequestParam Double lat,
                           @RequestParam Double lon,
                           HttpServletRequest servletRequest) {
        servletRequest.getSession().setAttribute("lat",lat);
        servletRequest.getSession().setAttribute("lon",lon);
        return "banki";
    }
}
