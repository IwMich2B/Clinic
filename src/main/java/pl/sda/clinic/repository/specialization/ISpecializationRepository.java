package pl.sda.clinic.repository.specialization;

import pl.sda.clinic.model.Specialization;

import java.util.List;

public interface ISpecializationRepository {

    List<Specialization> findAll();
    String findNameByID(Long id);
}
