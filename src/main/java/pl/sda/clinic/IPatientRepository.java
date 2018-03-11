package pl.sda.clinic;

import pl.sda.clinic.model.Patient;

import java.util.List;

public interface IPatientRepository {

    Patient createPatient(Patient Patient);

    Patient findPatient(String login) throws PatientNotFoundException;

    Patient updatePatient(Patient Patient) throws PatientNotFoundException;

    boolean deletePatient(String login) throws PatientNotFoundException;

    List<Patient> findAll();

}
