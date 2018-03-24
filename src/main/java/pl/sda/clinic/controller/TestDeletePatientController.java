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

@Controller
public class TestDeletePatientController {

    private static final Logger LOGGER =
            Logger.getLogger(TestDeletePatientController.class);

    //*************

//    @Autowired
//    PatientRepository patientRepository;

    final
    private PatientRepository patientRepository;

    @Autowired
    public TestDeletePatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    //*************

    @RequestMapping(path = "/test_delp", method = RequestMethod.POST)
    public String deletePatient(String login, Model model) {

        boolean done = false;

        try {
            patientRepository.deletePatient(login);
            model.addAttribute("result", "Usunięto pacjenta (login: " + login + ").");
        } catch (PatientNotFoundException e) {
           // e.printStackTrace();
            model.addAttribute("result", "Usunięcie nie powiodło się. Nie znaleziono pacjenta (login: " + login + ").");
        }

        model.addAttribute("done", Boolean.TRUE);//obyło by się bez tego?
        return "test_delete_patient";

   }

    @GetMapping("/test_delp")
    public String deletePatientForm(String login) {
        return "test_delete_patient";
    }
}