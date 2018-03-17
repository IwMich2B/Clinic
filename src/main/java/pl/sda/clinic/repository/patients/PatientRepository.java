package pl.sda.clinic.repository.patients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.clinic.model.Patient;
import pl.sda.clinic.repository.patients.IPatientRepository;
import pl.sda.clinic.repository.patients.PatientAlreadyExistsException;
import pl.sda.clinic.repository.patients.PatientJpaRepository;
import pl.sda.clinic.repository.patients.PatientNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PatientRepository implements IPatientRepository {


    @Autowired
    PatientJpaRepository patientJpaRepository;

   /* @Override
    public Boolean existsByLogin(String login) {
        return patientJpaRepository.existsByLogin(login);
    }*/

    @Override
    public Patient createPatient(Patient patient) throws PatientAlreadyExistsException {

        if (patientJpaRepository.existsByLogin(patient.getLogin())) {
            throw new PatientAlreadyExistsException(patient.getLogin());
        } else
            return patientJpaRepository.save(patient);

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
    public Patient findPatientByLoginAndPassword(String login, String password) {
        return patientJpaRepository.findPatientByLoginAndPassword(login, password);
    }

    @Override
    public Patient updatePatient(Patient patient) throws PatientNotFoundException {
        //TODO?
        return patientJpaRepository.save(patient);
    }

    @Override
    @Transactional
    public void deletePatient(String login) throws PatientNotFoundException {

        if (patientJpaRepository.existsByLogin(login)) {
            patientJpaRepository.deleteByLogin(login);
        } else
            throw new PatientNotFoundException(login);

    }

    @Override
    public List<Patient> findAll() {
        List<Patient> patients = new ArrayList<>();
        patientJpaRepository.findAll().forEach(patients::add);
        return patients;
    }
}
