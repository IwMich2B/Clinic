package pl.sda.clinic.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sda.clinic.PatientRepository;
import pl.sda.clinic.model.Patient;

@Controller
public class RegisterPatientController {

    private static final Logger LOGGER =
            Logger.getLogger(RegisterPatientController.class);

    @Autowired
    PatientRepository patientService;

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String addUser(Patient patient
                          ,BindingResult bindingResult
                          //, Model model
                          ) {

        if (bindingResult.hasErrors()){
            bindingResult.getAllErrors().
                    //forEach(LOGGER::info);
                            forEach(LOGGER::warn);
        }

        patientService.createPatient(patient);
        return "success";
    }

    @GetMapping("/register")
    public String addUserForm(Patient patient){
        return "register_patient";
    }


}
