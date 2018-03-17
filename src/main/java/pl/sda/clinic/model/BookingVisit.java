package pl.sda.clinic.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookingVisit {

    @Id
    private long visitId;
    private long doctorId;
    private long patientId;
    private long visitDate;
    private long visitHour;




}


