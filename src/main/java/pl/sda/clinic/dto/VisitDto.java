package pl.sda.clinic.dto;

import java.util.Date;

public class VisitDto {
    private int id;
    private String name;
    private String lastname;
    private Date dateTime;
    private String hoursVisit;

    public VisitDto() {
    }

    public VisitDto(int id, String name, String lastname, Date dateTime, String hoursVisit) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.dateTime = dateTime;
        this.hoursVisit = hoursVisit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getHoursVisit() {
        return hoursVisit;
    }

    public void setHoursVisit(String hoursVisit) {
        this.hoursVisit = hoursVisit;
    }

}
