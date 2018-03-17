package pl.sda.clinic.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "patients")
public class Patient {

    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;*/

    @Id
    @SequenceGenerator(name="patients_seq",
            sequenceName="patients_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="patients_seq")
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Size(min = 6, max = 18)
    //@Pattern //TODO
    private String login;

    @NotNull
    @Size(min = 8, max = 100)
    private String password;

    @Transient //żeby nie zapisywało do bazy danych
    @Size(min = 8, max = 100)
    private String retypedPassword;

    @Size(min = 3, max = 100)
    @Email
    private String email;

    @Size(min = 5, max = 10)
    //@Pattern //TODO
    private String phone;

    @NotNull
    @Size(min = 11)
    @Digits(integer = 11, fraction = 0)
    private String pesel;

    public Patient() {
    }

    public Patient(String firstName, String lastName, String login, String password, String retypedPassword, String email, String phone, String pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.retypedPassword = retypedPassword;
        this.email = email;
        this.phone = phone;
        this.pesel = pesel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRetypedPassword() {
        return retypedPassword;
    }

    public void setRetypedPassword(String retypedPassword) {
        this.retypedPassword = retypedPassword;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", retypedPassword='" + retypedPassword + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }
}