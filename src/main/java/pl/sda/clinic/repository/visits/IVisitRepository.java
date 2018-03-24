package pl.sda.clinic.repository.visits;

import pl.sda.clinic.model.Visit;

import java.util.List;

public interface IVisitRepository {

    List<Visit> findByPatient_Id (Long id);

    List<Visit> findVisitsByDoctorIdAndData(Long id, String data);

}
