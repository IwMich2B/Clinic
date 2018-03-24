package pl.sda.clinic.dto;

import pl.sda.clinic.model.Doctor;

public class DoctorForm {
    private Doctor doctor;
    private long id;

    public DoctorForm() {
    }

    public DoctorForm(Doctor doctor, long id) {
        this.doctor = doctor;
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public long getId() {
        return id;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setId(long id) {
        this.id = id;
    }
}
