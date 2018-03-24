package pl.sda.clinic.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "visits")
public class Visit {
    @Id
    @SequenceGenerator(name = "visits_sql",
            sequenceName = "visits_sql",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "visits_sql")
    private long id;
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_doctor")
    private Doctor doctor;
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_patient")
    private Patient patient;
    @Column(name = "visit_date")
    private String dateTime;
    @Column(name = "hours_visit")
    private String hoursVisit;

    public Visit() {
    }

    public Visit(Doctor doctor, Patient patient, String dateTime, String hoursVisit) {
        this.doctor = doctor;
        this.patient = patient;
        this.dateTime = dateTime;
        this.hoursVisit = hoursVisit;
    }
//    public Visit(long id, Doctor doctor, Patient patient, String dateTime, String hoursVisit) {
//        this.id = id;
//        this.doctor = doctor;
//        this.patient = patient;
//        this.dateTime = dateTime;
//        this.hoursVisit = hoursVisit;
//    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", doctor=" + doctor +
                ", patient=" + patient +
                ", dateTime=" + dateTime +
                ", hours_visit='" + hoursVisit + '\'' +
                '}';
    }
}
