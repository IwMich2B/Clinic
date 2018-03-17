package pl.sda.clinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SearchController {
    @RequestMapping(path = "/lista",method = RequestMethod.GET)
    public String serch(){
        return "odwolaj";
    }
}
