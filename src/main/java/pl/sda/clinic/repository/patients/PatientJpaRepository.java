package pl.sda.clinic.repository.patients;

import org.springframework.data.repository.CrudRepository;
import pl.sda.clinic.model.Patient;

public interface PatientJpaRepository extends CrudRepository<Patient, Long> {

    Patient findByLogin(String login);

    Patient findPatientById(Long id);

    void deleteByLogin(String login);

    Boolean existsByLogin(String login);

    Patient findPatientByLoginAndPassword(String login, String password);


}
