package mk.finki.ukim.mk.lab.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("banks")

public class BankController {

    @GetMapping
    public String getLoginPage() {
        return "banki";
    }
}
