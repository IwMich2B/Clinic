package pl.sda.clinic.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Doctor {
    @Id
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    private Specialization specialization;

    public Doctor() {
    }

    public Doctor(int id, String name, String lastName, Specialization specialization) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.specialization = specialization;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialization=" + specialization +
                '}';
    }
}

