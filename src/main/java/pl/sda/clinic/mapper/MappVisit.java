package pl.sda.clinic.mapper;

import org.springframework.stereotype.Component;
import pl.sda.clinic.dto.VisitDto;
import pl.sda.clinic.model.Visit;
import pl.sda.clinic.repository.specialization.SpecializationRepository;
@Component
public class MappVisit {
    public VisitDto mapVisit(Visit visit , SpecializationRepository specializationRepository) {
        VisitDto visitDto = new VisitDto();
        visitDto.setId(visit.getId());
        Long ids = visit.getDoctor().getSpecializationId();
        visitDto.setSpecializacja(specializationRepository.findNameByID(ids));
        visitDto.setName(visit.getDoctor().getName());
        visitDto.setLastname(visit.getDoctor().getLastName());
        visitDto.setDateTime(visit.getDateTime());
        visitDto.setHoursVisit(visit.getHoursVisit());

        return visitDto;
    }
}
