package pl.sda.clinic.services;

import org.springframework.stereotype.Service;
import pl.sda.clinic.dto.LoginForm;
import pl.sda.clinic.dto.SpecializationForm;
import pl.sda.clinic.model.Doctor;
import pl.sda.clinic.model.Patient;
import pl.sda.clinic.model.Specialization;
import pl.sda.clinic.repository.doctors.DoctorRepository;
import pl.sda.clinic.repository.patients.PatientRepository;

import javax.annotation.Resource;
import java.util.List;
@Service
public class DoctorService {
    @Resource(name = "doctorRepository")
    private DoctorRepository doctorRepository;

    public List<Doctor> doctorsBySpecialization (SpecializationForm specialization) {
        List<Doctor> doctorList = doctorRepository.findBySpecializationId(specialization.getSpecializationId());
        return doctorList;
    }
}
