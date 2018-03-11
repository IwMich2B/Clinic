package pl.sda.clinic;

public class PatientNotFoundException extends Exception {

    private static String ERROR = "PATIENT HAS NOT BEEN FOUND:";

    public PatientNotFoundException(String login) {
        super(ERROR + login);
    }

}
