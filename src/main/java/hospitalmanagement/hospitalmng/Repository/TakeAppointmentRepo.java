package hospitalmanagement.hospitalmng.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import hospitalmanagement.hospitalmng.Entity.TakeAppointment;

public interface TakeAppointmentRepo extends JpaRepository<TakeAppointment, Long> {

    List<TakeAppointment> findByPatientIdOrDoctorId(long patientId, long doctorId);

}
