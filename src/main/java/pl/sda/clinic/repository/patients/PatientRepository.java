package pl.sda.clinic.repository.patients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.clinic.model.Patient;

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


      /* @Override
    public Boolean existsByLoginIgnoreCase(String login) {
        return patientJpaRepository.existsByLoginIgnoreCase(login);
    }*/

    @Override
    public Patient createPatient(Patient patient) throws PatientAlreadyExistsException {

        if (patientJpaRepository.existsByLoginIgnoreCase(patient.getLogin())) {
            throw new PatientAlreadyExistsException(patient.getLogin());
        } else
            return patientJpaRepository.save(patient);

    }

    @Override
    public Patient findPatientById(Long id) throws PatientNotFoundException {

        Patient patient = patientJpaRepository.findById(id);

        if (patient == null)
            throw new PatientNotFoundException(id);
        else
            return patient;

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
    public Patient findPatientByLoginIgnoreCase(String login) throws PatientNotFoundException {
        Patient patient = patientJpaRepository.findByLoginIgnoreCase(login);
        if (patient == null)
            throw new PatientNotFoundException(login);
        else
            return patient;
    }

    @Override
    public Patient findPatientByLoginAndPassword(String login, String password) {
        return patientJpaRepository.findByLoginAndPassword(login, password);
    }

   /* @Override
    public Patient updatePatient(Patient patient) throws PatientNotFoundException {
        //TODO?    //uwaga na zmianę loginu
        return patientJpaRepository.save(patient);
    }*/

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
