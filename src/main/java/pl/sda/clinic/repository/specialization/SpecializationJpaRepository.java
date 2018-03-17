package pl.sda.clinic.repository.specialization;

import org.springframework.data.repository.CrudRepository;
import pl.sda.clinic.model.Specialization;

public interface SpecializationJpaRepository extends CrudRepository<Specialization,Long> {
}
