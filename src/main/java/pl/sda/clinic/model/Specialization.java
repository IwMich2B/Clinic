package pl.sda.clinic.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Specialization {

    @Id
    private long id;

    private String name;

    public Specialization() {
    }

    public Specialization(final long id,final String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
