package pl.sda.clinic.services;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import pl.sda.clinic.dto.LoginForm;
import pl.sda.clinic.model.Patient;
import pl.sda.clinic.repository.PatientRepository;

import javax.annotation.Resource;

@Service
public class PatientService {

    @Resource(name = "patientRepository")
    private PatientRepository patientRepository;

    public Patient login(LoginForm loginForm){
    Patient patient = patientRepository.findPatientByLoginAndPasssword(loginForm.getLogin(), loginForm.getPassword());
    return patient;
}


}
