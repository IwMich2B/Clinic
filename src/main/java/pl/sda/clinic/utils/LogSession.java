package pl.sda.clinic.utils;

import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Service
public class LogSession {

    public void checkSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Cookie cookieSessionTime = null;
        if (request.getCookies() != null){
            for (Cookie cookie : request.getCookies()){
                if (cookie.getName().equals("session-time")){
                    cookieSessionTime = cookie;
                    break;
                }
            }
        }
        if (session.getAttribute("patient") == null){
            if (cookieSessionTime != null){
                cookieSessionTime.setMaxAge(1);
                response.addCookie(cookieSessionTime);
            }
            if (!request.getRequestURI().contains("/login") && !request.getRequestURI().contains("/register")){
                response.sendRedirect("./login?error=session_expired");
            }
            return;
        }else{
            if (cookieSessionTime == null){
                session.invalidate();
                response.sendRedirect("./login?error=session_expired");
            }
        }
    }
}
