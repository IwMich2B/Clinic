package pl.sda.clinic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.sda.clinic.model.Patient;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PatientRepository implements IPatientRepository {


    @Autowired
    PatientJpaRepository patientJpaRepository;

    @Override
    public Patient createPatient(Patient patient) {
        return patientJpaRepository.save(patient);
    }

    @Override
    public Patient findPatient(String login) throws PatientNotFoundException {
        return patientJpaRepository.findByLogin(login);
    }

    @Override
    public Patient updatePatient(Patient patient) throws PatientNotFoundException {
        return patientJpaRepository.save(patient);
    }

    @Override
    public boolean deletePatient(String login) throws PatientNotFoundException {
        return patientJpaRepository.deletePatientByLogin(login);
    }

    @Override
    public List<Patient> findAll() {
        List<Patient> patients = new ArrayList<>();
        patientJpaRepository.findAll().forEach(patients::add);
        return patients;
    }
}
