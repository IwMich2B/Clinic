package pl.sda.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.clinic.repository.patients.PatientRepository;

@Controller
public class TestListaPacjentowController {

    //*************

//    @Autowired
//    PatientRepository patientRepository;

    final
    private PatientRepository patientRepository;

    @Autowired
    public TestListaPacjentowController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    //*************

    @GetMapping("/test_lp")
    public String countsList(Model model) {
        model.addAttribute("counts", patientRepository.findAll());
        return "test_lista_pacjentow";
    }
}