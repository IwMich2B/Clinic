package pl.sda.clinic.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.sda.clinic.model.Patient;

import java.util.List;

@Repository ("patientRepository")
public class PatientRepository {
    private static final String SELECT_BY_LOGIN_AND_PASSWORD_SQL = "SELECT * FROM users WHERE login = '%s' AND password = '%s'";


    @Autowired
    JdbcTemplate jdbcTemplate;

public Patient findPatientByLoginAndPasssword (String login, String password){
    BeanPropertyRowMapper<Patient> mapper = new BeanPropertyRowMapper<>(Patient.class);
    List<Patient> patients = jdbcTemplate.query(String.format(SELECT_BY_LOGIN_AND_PASSWORD_SQL, login, password), mapper);
    if (patients.size() == 1){
        return patients.get(0);
    }
    return null;
}
}

