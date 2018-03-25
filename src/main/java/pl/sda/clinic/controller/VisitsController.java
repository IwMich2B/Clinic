package pl.sda.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.clinic.dto.VisitDto;
import pl.sda.clinic.mapper.MappVisit;
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
    @Autowired
    MappVisit mappVisit;


    @RequestMapping(path = "/lista", method = RequestMethod.GET)
    public String visits(HttpServletRequest httpServletRequest, Model model,
                         @RequestParam(name = "deleted", required = false) Boolean deleted, HttpServletResponse response) {
        if (czyZalogowany(httpServletRequest)) {
            List<Visit> visits = visitRepository.findByPatient_Id((Long) (httpServletRequest.getSession().getAttribute("patientId")));
            //VisitDto visitDto = new VisitDto();
            List<VisitDto> visitDtoList = new ArrayList<>();
            for (Visit visit : visits) {
                VisitDto visitDto = mappVisit.mapVisit(visit, specializationRepository);
                visitDtoList.add(visitDto);
            }
            model.addAttribute("deleted", deleted);
            model.addAttribute("visits", visitDtoList);
            return "lista";
        }

        try {
            response.sendRedirect("/login");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(path = "/odwolaj", method = RequestMethod.GET)
    public String odwolaj(@RequestParam(name = "id", required = false)
                                  Long id, Model model, HttpServletRequest httpServletRequest, HttpServletResponse response) {
        if (!czyZalogowany(httpServletRequest)) {
            try {
                response.sendRedirect("/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        if (
                czyIDPacientaNalezyDoVizyty(id, (Long) httpServletRequest.getSession().getAttribute("patientId"))
                ) {

            Visit visitUsun = visitRepository.findById(id);
            VisitDto visitDto = mappVisit.mapVisit(visitUsun, specializationRepository);
            model.addAttribute("visit", visitDto);
            return "odwolaj";

        }

        return "clinic_open";
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

    private boolean czyZalogowany(HttpServletRequest httpServletRequest) {
        return ((httpServletRequest.getSession().getAttribute("patientId") != null) &&
                (httpServletRequest.getSession().getAttribute("patientLogin") != null));
    }

    private boolean czyIDPacientaNalezyDoVizyty(Long id_Visit, Long id_LogPacjent) {
        return (visitRepository.findById(id_Visit).getPatient().getId()).  //znajdz wizyte pacenta i jego id
                equals(id_LogPacjent);// zalogowany
    }


}


