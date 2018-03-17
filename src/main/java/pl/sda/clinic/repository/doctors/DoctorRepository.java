//package pl.sda.clinic.repository.doctors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import pl.sda.clinic.model.Doctor;
//
//import java.util.ArrayList;
//import java.util.List;
//
////@Repository
//public class DoctorRepository implements IDoctorRepository {
//
//    @Autowired
//    DoctorJpaRepository doctorJpaRepository;
//
////    private final List<Doctor> doctors;
////
////    public DoctorRepository() {
////        doctors = new ArrayList<>();
////        doctors.add(new Doctor(1, "Agnieszka Pediatra", 1));
////        doctors.add(new Doctor(2, "Marcin Internista", 2));
////        doctors.add(new Doctor(3, "Katarzyna Kardiolog", 3));
////        doctors.add(new Doctor(4, "Anna Pediatra", 1));
////        doctors.add(new Doctor(5, "Adam Internista", 2));
////    }
//
//    @Override
//    public List<Doctor> findAll() {
//        final List<Doctor> doctors = new ArrayList<>();
//
//        for (Doctor doctor : doctorJpaRepository.findAll()) {
//            doctors.add(doctor);
//        }
//
//        return doctors;
//
//    }
//
//    @Override
//    public List<Doctor> findDoctorsBySpecialization(final long specialisationId) {
//        final List<Doctor> doctorsBySpecialisation = new ArrayList<>();
//        for (final Doctor doctor : doctorsBySpecialisation) {
//            if (doctor.getSpecializationId() == specialisationId) {
//                doctorsBySpecialisation.add(doctor);
//            }
//        }
//        return doctorsBySpecialisation;
//    }
//
//
//}
