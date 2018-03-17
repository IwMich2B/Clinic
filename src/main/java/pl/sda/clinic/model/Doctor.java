package pl.sda.clinic.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;
    @NotNull
    @Column(name="name")
    private String name;

    @NotNull
    private String lastName;

    private long specializationId;

    public Doctor() {
    }

    public Doctor(long id, String name, long specializationId) {
        this.id = id;
        this.name = name;
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

