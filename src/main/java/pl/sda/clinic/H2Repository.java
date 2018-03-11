package pl.sda.clinic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.sda.clinic.model.Patient;

import java.util.ArrayList;
import java.util.List;

@Repository
public class H2Repository implements IPatientRepository {


    @Autowired
    PatientJpaRepository PatientJpaRepository;//USE JPA

    /*@PostConstruct
    public void init(){
        pl.sda.clinic.PatientJpaRepository.save(PatientGenerator.generatePatients());
    }*/

    @Override
    public Patient createPatient(Patient Patient) {
        return PatientJpaRepository.save(Patient);
    }

    @Override
    public Patient findPatient(String login) throws PatientNotFoundException {
        return PatientJpaRepository.findByLogin(login);
    }

    @Override
    public Patient updatePatient(Patient Patient) throws PatientNotFoundException {
        return PatientJpaRepository.save(Patient);
    }

    @Override
    public boolean deletePatient(String login) throws PatientNotFoundException {
        return PatientJpaRepository.deletePatientByLogin(login);
    }

    @Override
    public List<Patient> findAll() {
        //Iterable<Patient> all = pl.sda.clinic.PatientJpaRepository.findAll(); //??
        List<Patient> Patients = new ArrayList<>();
                PatientJpaRepository.findAll().forEach(Patients::add);//!!!
                return Patients;
    }
}
