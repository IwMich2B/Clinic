package pl.sda.clinic.dto;

import java.util.Date;

public class VisitDto {
    private Long id;
    private String specializacja;
    private String name;
    private String lastname;
    private String dateTime;
    private String hoursVisit;

    public VisitDto() {
    }

    public VisitDto(Long id, String specializacja, String name, String lastname, String dateTime, String hoursVisit) {
        this.id = id;
        this.specializacja = specializacja;
        this.name = name;
        this.lastname = lastname;
        this.dateTime = dateTime;
        this.hoursVisit = hoursVisit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecializacja() {
        return specializacja;
    }

    public void setSpecializacja(String specializacja) {
        this.specializacja = specializacja;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getHoursVisit() {
        return hoursVisit;
    }

    public void setHoursVisit(String hoursVisit) {
        this.hoursVisit = hoursVisit;
    }
}
