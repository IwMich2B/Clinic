package pl.sda.clinic.repository.patients;

public class PatientNotFoundException extends Exception {

    private static String ERROR = "PATIENT HAS NOT BEEN FOUND:";

    PatientNotFoundException(String login) {
        super(ERROR + login);
    }

}
