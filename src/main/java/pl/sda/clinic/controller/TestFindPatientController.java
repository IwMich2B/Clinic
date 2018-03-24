package pl.sda.clinic.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sda.clinic.repository.patients.PatientNotFoundException;
import pl.sda.clinic.repository.patients.PatientRepository;
import pl.sda.clinic.model.Patient;

@Controller
public class TestFindPatientController {

    private static final Logger LOGGER =
            Logger.getLogger(TestFindPatientController.class);

    //*************

//    @Autowired
//    PatientRepository patientRepository;

    final
    private PatientRepository patientRepository;

    @Autowired
    public TestFindPatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    //**************

    @RequestMapping(path = "/test_findp", method = RequestMethod.POST)
    public String findPatient(String login, Model model) {

        Patient patient;

        try {
            patient = patientRepository.findPatientByLogin(login);
            model.addAttribute("result", patient.toString());
        } catch (PatientNotFoundException e) {
            //e.printStackTrace()
            model.addAttribute("result", "Nie znaleziono pacjenta (login: " + login + ").");
        }

        model.addAttribute("done", Boolean.TRUE);//obyło by się bez tego?
        return "test_find_patient";
    }

    @GetMapping("/test_findp")
    public String findPatientForm(String login) {
        return "test_find_patient";
    }
}