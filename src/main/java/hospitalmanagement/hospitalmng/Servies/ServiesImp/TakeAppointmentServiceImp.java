package hospitalmanagement.hospitalmng.Servies.ServiesImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospitalmanagement.hospitalmng.Entity.TakeAppointment;
import hospitalmanagement.hospitalmng.Entity.User;
import hospitalmanagement.hospitalmng.Repository.TakeAppointmentRepo;
import hospitalmanagement.hospitalmng.Repository.UserRepo;
import hospitalmanagement.hospitalmng.Servies.TakeAppointmentService;

@Service
public class TakeAppointmentServiceImp implements TakeAppointmentService {

    @Autowired
    private TakeAppointmentRepo takeAppointmentRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public TakeAppointment CreteTakeAppointment(TakeAppointment takeAppointment) {
        return takeAppointmentRepo.save(takeAppointment);

    }

    @Override
    public boolean CancleTakeAppointment(boolean status) {
        return status;
    }

    @Override
    public List<TakeAppointment> GetAllAppiontment() {

        return takeAppointmentRepo.findAll();
    }

    @Override
    public TakeAppointment updateTakeAppointment(TakeAppointment infoAppointment) {

        takeAppointmentRepo.findById(infoAppointment.getId());
        User byId = userRepo.findById((long) infoAppointment.getDoctorId()).orElseThrow();
        infoAppointment.setDoctorName(byId.getFirstName());
        return takeAppointmentRepo.save(infoAppointment);

    }

    @Override
    public List<TakeAppointment> getAppointmentByUserId(Long userId) {
        return takeAppointmentRepo.findByPatientIdOrDoctorId(userId,userId);
    }

}
