package pl.sda.clinic.repository.patient;

public class PatientNotFoundException extends Exception {

    private static String ERROR = "PATIENT HAS NOT BEEN FOUND:";

    PatientNotFoundException(String login) {
        super(ERROR + login);
    }

}
