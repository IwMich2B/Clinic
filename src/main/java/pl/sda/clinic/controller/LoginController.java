package pl.sda.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.clinic.dto.LoginForm;
import pl.sda.clinic.model.Patient;
import pl.sda.clinic.services.PatientService;
import pl.sda.clinic.utils.LogSession;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    PatientService patientService;

    @Autowired
    LogSession logSession;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Patient patient){
        return "/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginForm(
        @ModelAttribute(value = "LoginForm") LoginForm form,
        HttpServletRequest request,
        HttpServletResponse response) throws IOException {

        Patient patient = patientService.login(form);
        if (patient != null) {
            //Otwieramy sesję użytkownika
            HttpSession session = request.getSession();
            session.setAttribute("patient", patient.getLogin());
            //Ustawiamy czas trwania sesji za pomocą ciasteczka
            Cookie cookie = new Cookie("session-time", "");
            cookie.setMaxAge(1200);
            response.addCookie(cookie);
            logSession.checkSession(request, response);

            return "redirect:./wyszukiwarka";
        }else{
            return "redirect:./login?error";
        }

    }


}
