package hospitalmanagement.hospitalmng.Servies;

import java.util.List;

import hospitalmanagement.hospitalmng.Entity.TakeAppointment;

public interface TakeAppointmentService {

    TakeAppointment CreteTakeAppointment(TakeAppointment takeAppointment);

    boolean CancleTakeAppointment(boolean status);

    List<TakeAppointment> GetAllAppiontment();

    TakeAppointment updateTakeAppointment(TakeAppointment infoAppointment);

  List<TakeAppointment> getAppointmentByUserId(Long userId);

}
