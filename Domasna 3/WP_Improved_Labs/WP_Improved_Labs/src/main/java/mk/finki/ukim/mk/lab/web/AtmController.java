package mk.finki.ukim.mk.lab.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/atms")
public class AtmController {


    @PostMapping
    public String getLoginPage(@RequestParam Double lat,
                               @RequestParam Double lon,
                               HttpServletRequest httpServletRequest) {

        if(httpServletRequest.getSession().getAttribute("lat") != null){
            httpServletRequest.getSession().removeAttribute("lat");
        }

        if(httpServletRequest.getSession().getAttribute("lon") != null){
            httpServletRequest.getSession().removeAttribute("lon");
        }

        httpServletRequest.getSession().setAttribute("lat",lat);
        httpServletRequest.getSession().setAttribute("lon",lon);


        return "bankomati";
    }

}
