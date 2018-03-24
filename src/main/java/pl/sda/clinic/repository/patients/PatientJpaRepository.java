package pl.sda.clinic.repository.patients;

import org.springframework.data.repository.CrudRepository;
import pl.sda.clinic.model.Patient;

public interface PatientJpaRepository extends CrudRepository<Patient, Long> {

    Patient findByLogin(String login);

    Patient findByLoginIgnoreCase(String login);

    Patient findById(Long id);

    void deleteByLogin(String login);

    Boolean existsByLogin(String login);

    Boolean existsByLoginIgnoreCase(String login);

    Patient findByLoginAndPassword(String login, String password);


}
