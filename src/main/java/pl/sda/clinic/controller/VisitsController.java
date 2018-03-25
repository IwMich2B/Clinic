package pl.sda.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.clinic.dto.VisitDto;
import pl.sda.clinic.model.Visit;
import pl.sda.clinic.repository.specialization.SpecializationRepository;
import pl.sda.clinic.repository.visits.VisitRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class VisitsController {

    @Autowired
    VisitRepository visitRepository;
    @Autowired
    SpecializationRepository specializationRepository;


    @RequestMapping(path = "/lista", method = RequestMethod.GET)
    public String visits(HttpServletRequest httpServletRequest, Model model, @RequestParam(name = "deleted", required = false) Boolean deleted) {

        List<Visit> visits = visitRepository.findByPatient_Id((Long) (httpServletRequest.getSession().getAttribute("patientId")));
        //VisitDto visitDto = new VisitDto();
        List<VisitDto> visitDtoList = new ArrayList<>();
        for (Visit visit : visits) {
            VisitDto visitDto = mapVisit(visit);
            visitDtoList.add(visitDto);
        }
        model.addAttribute("deleted", deleted);
        model.addAttribute("visits", visitDtoList);
        return "lista";
    }

    @RequestMapping(path = "/odwolaj", method = RequestMethod.GET)
    public String odwolaj(@RequestParam(name = "id", required = false) Long id, Model model) {
        Visit visitUsun = visitRepository.findById(id);
        VisitDto visitDto = mapVisit(visitUsun);
        model.addAttribute("visit", visitDto);
        return "odwolaj";
    }


    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public void deleteVisit(@RequestParam long id_visit, Model model, HttpServletResponse response) {
        visitRepository.delete(id_visit);

        try {
            response.sendRedirect("/lista?deleted=true");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private VisitDto mapVisit(Visit visit) {
        VisitDto visitDto = new VisitDto();
        visitDto.setId(visit.getId());
        Long ids = visit.getDoctor().getSpecializationId();
        visitDto.setSpecializacja(specializationRepository.findNameByID(ids));
        visitDto.setName(visit.getDoctor().getName());
        visitDto.setLastname(visit.getDoctor().getLastName());
        visitDto.setDateTime(visit.getDateTime());
        visitDto.setHoursVisit(visit.getHoursVisit());

        return visitDto;
    }

}


