package pl.sda.clinic.repository.doctors;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sda.clinic.model.Doctor;

import java.util.List;

@Repository
public interface DoctorJpaRepository extends CrudRepository<Doctor, Long> {
//    List<Doctor> findAll();

//    List<Doctor> findBySpecializationId(final long specialisationId);
    List<Doctor> findBySpecializationId(long specializationId);

}
