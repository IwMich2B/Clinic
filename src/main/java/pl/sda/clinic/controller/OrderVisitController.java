package pl.sda.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.clinic.dto.LoginForm;
import pl.sda.clinic.dto.SpecializationForm;
import pl.sda.clinic.model.Patient;
import pl.sda.clinic.repository.doctors.DoctorJpaRepository;
import pl.sda.clinic.model.Doctor;
import pl.sda.clinic.repository.specialization.SpecializationRepository;

import java.util.List;

@Controller
public class OrderVisitController {

    @Autowired
    DoctorJpaRepository doctorJpaRepository;

    @Autowired
    SpecializationRepository specializationRepository;


    @RequestMapping(path = "/specialization", method = RequestMethod.GET)
public ModelAndView specialization() {
    final ModelAndView modelAndView = new ModelAndView("specialization");

    modelAndView.addObject("specialization", specializationRepository.findAll());
    return modelAndView;
}
    @RequestMapping(path = "/specialization", method = RequestMethod.POST)
    public String specializationForm(
        @ModelAttribute(value = "specialization") SpecializationForm specialization) {

        return "redirect:./doctor";
    }


    @RequestMapping(path = "/doctor", method = RequestMethod.GET)
    public ModelAndView doctor(@ModelAttribute(value="specialization") SpecializationForm specialization) {
        final ModelAndView modelAndView = new ModelAndView("doctor");
        modelAndView.addObject("doctor", doctorJpaRepository
                .findBySpecializationId(specialization.getSpecializationId()));
        return modelAndView;
    }
//    @RequestMapping(path = "/order", method = RequestMethod.GET)
//    public ModelAndView menu() {
//        final ModelAndView modelAndView = new ModelAndView("order_visit");
//
//        modelAndView.addObject("specialization", specializationRepository.findAll());
//

        //run to load all doctors
//        final List<Doctor> doctors = doctorJpaRepository.findAll();
//        modelAndView.addObject("doctor", doctors);

//        //run to load doctors by specialization
//        final List<Doctor> doctorsBySpec = doctorJpaRepository.findBySpecializationId(1);
//        modelAndView.addObject("doctor", doctorsBySpec);
//        return modelAndView;
//    }
}
