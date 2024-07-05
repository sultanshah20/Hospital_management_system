package hospitalmanagement.hospitalmng.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class TakeAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String appointmentdate;
    private String prescription;
    private String treatmentprice;
    private String appointmentstatus;
    // AssignByDoctor
    private String patientname;
    private String contactNo;
    private String problemdescription;
    private int doctorId;
    private String doctorName;
    private long patientId;
    private boolean cancelStatus;
}
