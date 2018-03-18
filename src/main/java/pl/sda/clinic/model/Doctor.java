package pl.sda.clinic.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @SequenceGenerator(name = "doctors_seq",
            sequenceName = "doctors_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "doctors_seq")
    private long id;
    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "specialization_id")
    private long specializationId;

    public Doctor() {
    }

    public Doctor(long id, String name, String lastName, long specializationId) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.specializationId = specializationId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSpecializationId(long specializationId) {
        this.specializationId = specializationId;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSpecializationId(long specializationId) {
        this.specializationId = specializationId;
    }

    public long getSpecializationId() {
        return specializationId;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specializationId=" + specializationId +
                '}';
    }
}

