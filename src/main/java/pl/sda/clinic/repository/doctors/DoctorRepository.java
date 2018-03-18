package pl.sda.clinic.repository.doctors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.sda.clinic.model.Doctor;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DoctorRepository implements IDoctorRepository {

    @Autowired
    DoctorJpaRepository doctorJpaRepository;


    @Override
    public List<Doctor> findAll() {
        final List<Doctor> doctors = new ArrayList<>();

        for (Doctor doctor : doctorJpaRepository.findAll()) {
            doctors.add(doctor);
        }

        return doctors;
    }


    @Override
    public List<Doctor> findBySpecializationId(final long specialisationId) {
        final List<Doctor> doctorsBySpecialisation = new ArrayList<>();
        for (final Doctor doctor : doctorsBySpecialisation) {
            if (doctor.getSpecializationId() == specialisationId) {
                doctorsBySpecialisation.add(doctor);
            }
        }
        return doctorsBySpecialisation;
    }



}
