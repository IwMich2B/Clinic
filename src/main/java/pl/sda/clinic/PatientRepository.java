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
    public Patient createPatient(Patient patient) throws PatientAlreadyExistsException {

        if (patientJpaRepository.findByLogin(patient.getLogin()) == null) {
            return patientJpaRepository.save(patient);
        } else
            throw new PatientAlreadyExistsException(patient.getLogin());

    }

    @Override
    public Patient findPatientByLogin(String login) throws PatientNotFoundException {

        Patient patient = patientJpaRepository.findByLogin(login);
        if (patient == null)
            throw new PatientNotFoundException(login);
        else
            return patient;
    }

    @Override
    public Patient updatePatient(Patient patient) throws PatientNotFoundException {
        //TODO?
        return patientJpaRepository.save(patient);
    }

    @Override
    public boolean deletePatient(String login) throws PatientNotFoundException {
        //TODO?
        return patientJpaRepository.deleteByLogin(login);
    }

    @Override
    public List<Patient> findAll() {
        List<Patient> patients = new ArrayList<>();
        patientJpaRepository.findAll().forEach(patients::add);
        return patients;
    }
}
