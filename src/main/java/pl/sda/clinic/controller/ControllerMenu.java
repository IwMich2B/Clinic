package pl.sda.clinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerMenu {
    @RequestMapping(path = "/menu", method = RequestMethod.GET)
    public String menu(){
        return "clinic_open";
    }







}
