package pl.sda.clinic.repository.specialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.sda.clinic.model.Specialization;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SpecializationRepository implements ISpecializationRepository {

    @Autowired
    SpecializationJpaRepository specializationJpaRepository;

    @Override
    public List<Specialization> findAll() {


                List<Specialization> specializations = new ArrayList<>();
        for (final Specialization specialization : specializationJpaRepository.findAll()) {
            specializations.add(specialization);
        }
        return specializations;
    }
}
