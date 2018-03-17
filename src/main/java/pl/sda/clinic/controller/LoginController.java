package pl.sda.clinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.clinic.dto.LoginForm;
import pl.sda.clinic.model.Patient;

import java.util.List;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Patient patient){
        return "/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginForm(
        @ModelAttribute(value = "login") LoginForm form){
        return "/wyszukiwarka";
    }


}
