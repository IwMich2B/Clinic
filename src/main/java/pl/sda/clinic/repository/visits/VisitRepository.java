package pl.sda.clinic.repository.visits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.sda.clinic.model.Visit;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Repository
public class VisitRepository implements IVisitRepository {
    @Autowired
    VisitJpaRepository visitJpaRepository;
    @Override
    public List<Visit> findByPatient_Id(Long id) {
      List< Visit> visits = visitJpaRepository.findByPatient_Id(id);
        return visits;
    }
}
