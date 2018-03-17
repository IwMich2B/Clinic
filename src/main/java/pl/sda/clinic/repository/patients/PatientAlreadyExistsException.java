package pl.sda.clinic.repository.patients;

public class PatientAlreadyExistsException extends Exception {

    private static String ERROR = "PATIENT ALREADY EXISTS:";

    PatientAlreadyExistsException(String login) {
        super(ERROR + login);
    }

}
