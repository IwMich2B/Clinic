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
    public List<String> findVisitsByDoctorIdAndData(Long id, String data) {
        HarmonogramItem harmonogramItem = new HarmonogramItem();
        List<Visit> visits = visitJpaRepository.findVisitsByDoctor_IdAndDateTime(id, data);
        List<String> allHours = harmonogramItem.createTimetable();

        List<String> results = new ArrayList<>();
        for (String allHour : allHours) {
            boolean isBusy = false;
            {
                for (Visit visit : visits) {
                    if (visit.getHoursVisit().equals(allHour)){
                        isBusy = true;
                    break;}
                }
                if (!isBusy) {
                    results.add(allHour);

                }
            }

        }
        return results;
    }
    @Override
    public Visit findById(Long id) {
        return visitJpaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
       // if(visitJpaRepository.exists(id)){
            visitJpaRepository.delete(id);
       // }
    }
}