package pl.sda.clinic.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import java.util.List;

    public class Harmonogram {

        @SequenceGenerator(name = "visits_sql",
                sequenceName = "visits_sql",
                allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE,
                generator = "visits_sql")
        private long harmonogramId;
        private long doctorId;
        private String day;
        private List<HarmonogramItem>harmonogramItemList;


        public Harmonogram() {
        }

        public Harmonogram(long doctorId, String day, List<HarmonogramItem> harmonogramItemList) {
            this.doctorId = doctorId;
            this.day = day;
            this.harmonogramItemList = harmonogramItemList;
        }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<HarmonogramItem> getHarmonogramItemList() {
        return harmonogramItemList;
    }

    public void setHarmonogramItemList(List<HarmonogramItem> harmonogramItemList) {
        this.harmonogramItemList = harmonogramItemList;
    }


}


