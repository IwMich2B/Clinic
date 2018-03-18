package pl.sda.clinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "specjalizacja", schema = "public")
public class Specialization {

    @Id
    @Column(name="id")
    private long id;
    @Column(name="value")
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

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
