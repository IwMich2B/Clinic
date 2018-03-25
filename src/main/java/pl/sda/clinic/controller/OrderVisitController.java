package pl.sda.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.clinic.dto.SpecializationForm;
import pl.sda.clinic.dto.VisitDto;
import pl.sda.clinic.model.*;
import pl.sda.clinic.repository.doctors.DoctorJpaRepository;
import pl.sda.clinic.repository.hour.HourRepository;
import pl.sda.clinic.repository.patients.PatientJpaRepository;
import pl.sda.clinic.repository.specialization.SpecializationRepository;
import pl.sda.clinic.repository.visits.VisitJpaRepository;
import pl.sda.clinic.repository.visits.VisitRepository;
import pl.sda.clinic.services.DoctorService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class OrderVisitController {

    @Autowired
    DoctorJpaRepository doctorJpaRepository;

    @Autowired
    SpecializationRepository specializationRepository;

    @Autowired
    DoctorService doctorService;

    @Autowired
    VisitRepository visitRepository;

    @Autowired
    PatientJpaRepository patientJpaRepository;

    @Autowired
    HourRepository hourRepository;

    @Autowired
    VisitJpaRepository visitJpaRepository;

    @RequestMapping(path = "/specialization", method = RequestMethod.GET)
    public ModelAndView specialization(HttpServletRequest request) {
        final ModelAndView modelAndView = new ModelAndView("specialization");
        modelAndView.addObject("specialization", specializationRepository.findAll());
        HttpSession session = request.getSession();
        return modelAndView;
    }

    @RequestMapping(path = "/specialization", method = RequestMethod.POST)
    public String specializationForm(@ModelAttribute(value = "specialization") SpecializationForm specialization, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("specializationName",specialization.getSpecialization().getName());

        session.setAttribute("specialization", specialization.getSpecialization().getId());
        return "redirect:./doctor";
    }

    @RequestMapping(path = "/doctor", method = RequestMethod.GET)
    public ModelAndView doctor(@ModelAttribute(value = "specialization") SpecializationForm specialization, HttpServletRequest request, Patient patient) {
        final ModelAndView modelAndView = new ModelAndView("doctor");

        long specializationId = (long) request.getSession().getAttribute("specialization");
        modelAndView.addObject("doctor", doctorJpaRepository.findBySpecializationId(specializationId));
        return modelAndView;
    }

    @RequestMapping(path = "/doctor", method = RequestMethod.POST)
    public String redirectToVisitSummary(@ModelAttribute(value = "doctor") Doctor doctor,
                                         @ModelAttribute(value = "data") String data,
                                         @ModelAttribute(value = "hours") String hours,
                                         HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("doctorId", doctor.getId());
        session.setAttribute("visitData", data);
        session.setAttribute("doctor", doctor);
        session.setAttribute("hours",hours);
        return "redirect:./hour";
    }

    @RequestMapping(path = "/hour", method = RequestMethod.GET)
    public ModelAndView getHourView(@ModelAttribute(value = "doctor") Doctor doctor,
                                    @ModelAttribute(value = "data") String data,
                                            HttpServletRequest request) {
        long doctorId = (long) request.getSession().getAttribute("doctorId");
        String dataVisit = (String) request.getSession().getAttribute("visitData");
        final ModelAndView modelAndView = new ModelAndView("hour");
//        modelAndView.addObject("hours", visitRepository.findVisitsByDoctorIdAndData(doctorId,dataVisit));
////                hourRepository.getHoursByDoctor(doctorId));
        modelAndView.addObject("hour",
                visitRepository.findVisitsByDoctorIdAndData(doctorId, (String) request.getSession().getAttribute("visitData")));
        return modelAndView;
    }

    @RequestMapping(path = "/hour", method = RequestMethod.POST)
    public String redirectToVisitSummary(@ModelAttribute(value = "hour") HarmonogramItem harmonogramItem, HttpServletRequest request) {
        final HttpSession session = request.getSession();
        final String visitData = (String) session.getAttribute("visitData");
        final Doctor doctor = (Doctor) session.getAttribute("doctor");
        final long patientId = (long) session.getAttribute("patientId");
        final Patient patient = patientJpaRepository.findById(patientId);

        List<Visit> visits = visitJpaRepository.findByDoctor_Id(doctor.getId());

        // new Visit(doctorId, patirntId, visitData, hour);
        final Visit visit = new Visit(doctor, patient, visitData, harmonogramItem.getHour());
        visitJpaRepository.save(visit);
        long visitId = visit.getId();
        return "redirect:./summary_visit";
    }


//    @RequestMapping(path = "/summary_visit", method = RequestMethod.GET)
//    public ModelAndView summary_visit(HttpServletRequest request, Visit visita) {
//        final ModelAndView modelAndView = new ModelAndView("summary_visit");
//        final Visit visit = visitJpaRepository.findOne(visita.getId());
////        modelAndView.addObject("summary_visit", hourJpaRepository.findById(hourId));
//        return modelAndView;
//    }
    @RequestMapping(path = "/summary_visit", method = RequestMethod.GET)
    public ModelAndView summary_visit(HttpServletRequest request) {
        final ModelAndView modelAndView = new ModelAndView("summary_visit");
        HttpSession session = request.getSession();
        session.getAttribute("doctorId");
        session.getAttribute("specializationName");
        session.getAttribute("visitData");
        session.getAttribute("doctor");
        session.getAttribute("hours");
        //final VisitDto visit = visitJpaRepository.findOne(visit.getId());
//        modelAndView.addObject("summary_visit", hourJpaRepository.findById(hourId));
        return modelAndView;
    }

}