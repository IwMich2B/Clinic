package pl.sda.clinic.repository.visits;

import pl.sda.clinic.model.Visit;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IVisitRepository {

    List<Visit> findByPatient_Id (Long id);
}
