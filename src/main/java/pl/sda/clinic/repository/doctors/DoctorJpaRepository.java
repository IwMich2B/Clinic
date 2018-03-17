package pl.sda.clinic.repository.doctors;

import org.springframework.data.repository.CrudRepository;
import pl.sda.clinic.model.Doctor;

import java.util.List;

public interface DoctorJpaRepository extends CrudRepository<Doctor, Long> {
    List<Doctor> findAll();

//    List<Doctor> findBySpecializationId(final long specialisationId);
    List<Doctor> findBySpecializationId();

}
