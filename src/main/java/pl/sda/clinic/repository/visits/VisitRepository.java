package pl.sda.clinic.repository.visits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.sda.clinic.model.Harmonogram;
import pl.sda.clinic.model.HarmonogramItem;
import pl.sda.clinic.model.Visit;
import pl.sda.clinic.repository.hour.HourRepository;
import pl.sda.clinic.repository.patients.PatientAlreadyExistsException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VisitRepository implements IVisitRepository {

    @Autowired
    VisitJpaRepository visitJpaRepository;
    @Autowired
    HourRepository hourRepository;

    @Override
    public List<Visit> findByPatient_Id(Long id) {
        return visitJpaRepository.findByPatient_Id(id);
    }

    @Override
    public List<Visit> findVisitsByDoctorIdAndData(Long id, String data) {
        final List<Visit> doctorVisit = visitJpaRepository.findByDoctor_Id(id);
//        HarmonogramItem hour = new HarmonogramItem();

        Harmonogram harmonogram = new Harmonogram();
        List<HarmonogramItem> harmonograms = harmonogram.getHarmonogramItemList();

        List<HarmonogramItem> allHours = hourRepository.getHoursByDoctor(id);


//        List<String> allHours = hour.createTimetable();
        final List<Visit> reservedVisits = new ArrayList<>();

        for (final Visit visit : doctorVisit) {
            if (visit.getDateTime().equals(data)) {

                for (final HarmonogramItem time : allHours) {

                    if (!visit.getHoursVisit().equals(time.toString())) {
                        reservedVisits.add(visit);
                    }
                }
            }
        }
        return reservedVisits;
    }
//        return harmonogramm.getHarmonogramItemList();


}
