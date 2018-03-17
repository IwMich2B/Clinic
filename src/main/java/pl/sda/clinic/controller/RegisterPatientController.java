package pl.sda.clinic.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sda.clinic.PatientAlreadyExistsException;
import pl.sda.clinic.PatientRepository;
import pl.sda.clinic.model.Patient;

import javax.validation.Valid;

@Controller
public class RegisterPatientController {

    private static final Logger LOGGER =
            Logger.getLogger(RegisterPatientController.class);

    //*************

//    @Autowired
//    PatientRepository patientRepository;

    final
    private PatientRepository patientRepository;

    @Autowired
    public RegisterPatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    //*************


    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String addPatient(@Valid Patient patient
            , BindingResult bindingResult //BindingResult musi być zaraz po obiekcie z adnotacją @Valid.
                             //, Model model
    ) {

        boolean isValid = true;



        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().
                    //forEach(LOGGER::info);
                            forEach(LOGGER::warn);
            isValid = false;
        }

        if (!bindingResult.hasFieldErrors(patient.getPassword()) && !bindingResult.hasFieldErrors(patient.getPassword())
                && !patient.getPassword().equals(patient.getRetypedPassword())) {
            bindingResult.rejectValue("retypedPassword", "Passwords don't match", "Hasła nie są identyczne.");
            // void rejectValue(String field, String errorCode, String defaultMessage);
            // drugi parametr to kod błedu, trzeci parametr to komunikat o błędzie
            isValid = false;
        }


        /*if (patientRepository.existsByLogin(patient.getLogin())) {
            bindingResult.rejectValue("login", "Patient already exists.", "Wybrany login jest zajęty.");
            isValid = false;
        }*/  //TODO czy wystarczy złapanie tego poniższym catch'em ?


        if (isValid) try {
            patientRepository.createPatient(patient);
        } catch (PatientAlreadyExistsException e) {
            //e.printStackTrace();
            bindingResult.rejectValue("login", "Patient already exists.", "Wybrany login jest zajęty.");
            isValid = false;
        }

        if (isValid)
            return "redirect:/register?message=register_success_" + patient.getLogin();//TODO GDZIE MA WYLĄDOWAĆ?
        else
            return "register_patient";
    }

    //**********

    @GetMapping("/register")
    public String addPatientForm(Patient patient) {
        return "register_patient";
    }


}
