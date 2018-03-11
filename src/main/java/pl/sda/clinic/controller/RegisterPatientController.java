package pl.sda.clinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sda.clinic.model.Patient;

@Controller
public class RegisterPatientController {

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String addUser(Patient patient
                          //,BindingResult bindingResult
                          , Model model
                          ) {

        //TODO CREATEUSER
    return "success";
    }

    //@RequestMapping(path = "/", method = RequestMethod.GET) //też zadziała
    @GetMapping("/register")
    public String addUserForm(Patient patient){
        return "register_patient";
    }
}
