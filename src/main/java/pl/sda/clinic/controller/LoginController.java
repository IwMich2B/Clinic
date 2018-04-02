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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
public class LoginController {

    @Autowired
    PatientService patientService;

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
            session.setAttribute("patientLogin", patient.getLogin());
            session.setAttribute("patientId", patient.getId());
            return "redirect:./specialization";
        }else{
            return "redirect:./login?error";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request)
           throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("patientLogin");
            session.removeAttribute("patientId");
            session.invalidate();
        }
        return "redirect:/menu";
}

    }

