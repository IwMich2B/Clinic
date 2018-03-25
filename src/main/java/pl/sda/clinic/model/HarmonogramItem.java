package pl.sda.clinic.model;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class HarmonogramItem {
    @Id
    @SequenceGenerator(name = "visits_sql",
            sequenceName = "visits_sql",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "visits_sql")
    private long harmonogramItemId;

    @Column(name = "hours_visit")
    private String hour;

    boolean isAvailable;

    public HarmonogramItem() {
    }

    public HarmonogramItem(String hour, boolean isAvailable) {
        this.hour = hour;
        this.isAvailable = isAvailable;
    }

    public HarmonogramItem(String hour) {
        this.hour = hour;
    }

    public long getHarmonogramItemId() {
        return harmonogramItemId;
    }

    public void setHarmonogramItemId(long harmonogramItemId) {
        this.harmonogramItemId = harmonogramItemId;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public List<String> createTimetable() {
        final List<String> hourList = new ArrayList<>();

        int hour = 8;
        int minutes = 0;

        for (int i = 0; i < 19; i++) {
            hourList.add(LocalTime.of(hour, minutes).toString());
            if (minutes == 30) {
                minutes = 0;
                hour += 1;
            } else {
                minutes = 30;
            }
        }
        return hourList;
    }}
