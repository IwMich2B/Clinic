package pl.sda.clinic.repository.visits;

import org.hibernate.sql.Delete;
import org.springframework.data.repository.CrudRepository;
import pl.sda.clinic.model.Patient;
import pl.sda.clinic.model.Visit;

import java.util.List;


public interface VisitJpaRepository extends CrudRepository<Visit,Long> {
    List<Visit> findByPatient_Id (Long id);

    List<Visit> findByDoctor_Id(Long id);
    Visit findById (Long id);
    void delete(Long id);



}
