package pl.sda.clinic.model;

import javax.persistence.*;

@Entity
@Table(name = "specjalizacja", schema = "public")
public class Specialization {

    @Id
    @SequenceGenerator(name="specjalizacja_seq",
            sequenceName="specjalizacja_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="specjalizacja_seq")
    private long id;
    @Column(name="value")
    private String name;

    public Specialization() {
    }

    public Specialization(long id, String name) {
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

    @Override
    public String toString() {
        return "Specialization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
