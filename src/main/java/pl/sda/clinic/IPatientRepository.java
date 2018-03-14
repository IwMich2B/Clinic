package pl.sda.clinic;

import pl.sda.clinic.model.Patient;

import java.util.List;

public interface IPatientRepository {

    Patient createPatient(Patient patient) throws PatientAlreadyExistsException;

    Patient findPatientByLogin(String login) throws PatientNotFoundException;

    Patient updatePatient(Patient patient) throws PatientNotFoundException;

    void deletePatient(String login) throws PatientNotFoundException;

    List<Patient> findAll();

}
