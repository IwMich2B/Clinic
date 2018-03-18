package pl.sda.clinic.dto;

import pl.sda.clinic.model.Specialization;

public class SpecializationForm {
    private Specialization specialization;
    private long id;

    public SpecializationForm() {
    }

    public SpecializationForm(Specialization specialization, long specializationId) {
        this.specialization = specialization;
        this.id = specializationId;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public long getSpecializationId() {
        return id;
    }

    public void setSpecializationId(long specializationId) {
        this.id = specializationId;
    }
}

