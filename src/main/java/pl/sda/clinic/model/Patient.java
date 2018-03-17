package pl.sda.clinic.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50, message = "{firstName.size}")//dodałam
    private String firstName;

    @NotNull
    @Size(min = 2, max = 50, message = "{lastName.size}")//dodałam
    private String lastName;

    @NotNull
    @Size(min = 6, max = 18, message = "{login.size}")//dodałam max
    //@Pattern//dodałam
    private String login;

    @NotNull
    @Size(min = 8, max = 128, message = "{password.size}")//dodałam max
    private String password;

    @Transient //dodałam
    @Size(min = 8, max = 128, message = "{retypedPassword.size}") //dodałam
    private String retypedPassword; //dodałam wraz z seterem i geterem

    @NotNull
    @Size(min = 11)
    @Digits(integer = 11, fraction = 0)//dodałam
    //@ValidPesel(message = "{pesel.validPesel}") //dodałam
    private String pesel;

    /*
    @Size(min = 3, max = 254)//dodałam
    @Email(message="email.valid")//dodałam
    private String email;//dodałam */

    public Patient() {
    }

    public Patient(Long id, String firstName, String lastName, String login, String password, String pesel) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
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

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName=" + firstName + '\'' +
                ", lastName=" + lastName + '\'' +
                ", login=" + login + '\'' +
                ", password=" + password + '\'' +
                ", pesel=" + pesel + '\'' +
                '}';
    }
}