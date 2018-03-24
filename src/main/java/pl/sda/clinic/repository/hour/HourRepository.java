package pl.sda.clinic.repository.hour;

import org.springframework.stereotype.Repository;
import pl.sda.clinic.model.Harmonogram;
import pl.sda.clinic.model.HarmonogramItem;
import pl.sda.clinic.model.Visit;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HourRepository {

    public List<HarmonogramItem> getHoursByDoctor(long doctorId) {
        List<HarmonogramItem> harmonogramItemList = new ArrayList<>();
        HarmonogramItem hour = new HarmonogramItem();
        Visit visit = new Visit();
        List<String> listOfHours = hour.createTimetable();
        for (int i = 0; i < listOfHours.size(); i++) {

            final HarmonogramItem harmonogramItem;
            harmonogramItem = new HarmonogramItem(listOfHours.get(i), true);
            if (harmonogramItem.isAvailable()) {
                harmonogramItemList.add(harmonogramItem);
            }
        }
        final Harmonogram harmonogram = new Harmonogram(1,visit.getDateTime(), harmonogramItemList);
        return harmonogram.getHarmonogramItemList();
    }
}
