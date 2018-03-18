package pl.sda.clinic.dto;

import pl.sda.clinic.model.Specialization;

public class SpecializationForm {
    private Specialization specialization;
    private long specializationId;

    public SpecializationForm() {
    }

    public SpecializationForm(Specialization specialization, long specializationId) {
        this.specialization = specialization;
        this.specializationId = specializationId;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public long getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(long specializationId) {
        this.specializationId = specializationId;
    }
}

