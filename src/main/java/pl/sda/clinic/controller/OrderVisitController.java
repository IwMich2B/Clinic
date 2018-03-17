package pl.sda.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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

    @RequestMapping(path = "/order", method = RequestMethod.GET)
    public ModelAndView menu() {
        final ModelAndView modelAndView = new ModelAndView("order_visit");

        modelAndView.addObject("specialization", specializationRepository.findAll());


        //run to load all doctors
//        final List<Doctor> doctors = doctorJpaRepository.findAll();
//        modelAndView.addObject("doctor", doctors);

        //run to load doctors by specialization
        final List<Doctor> doctorsBySpec = doctorJpaRepository.findBySpecializationId(1);
        modelAndView.addObject("doctor", doctorsBySpec);
        return modelAndView;
    }
}
