package pl.sda.clinic;

public class PatientAlreadyExistsException extends Exception {

    private static String ERROR = "PATIENT ALREADY EXISTS:";

    public PatientAlreadyExistsException(String login) {
        super(ERROR + login);
    }

}
