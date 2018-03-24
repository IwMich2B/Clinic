package pl.sda.clinic.repository.doctors;

import pl.sda.clinic.model.Doctor;
import pl.sda.clinic.model.Specialization;

import java.util.List;

public interface IDoctorRepository {

    List<Doctor> findAll();

    List<Doctor> findBySpecializationId(final long specialisationId);


}
