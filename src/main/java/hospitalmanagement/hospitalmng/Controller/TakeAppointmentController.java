package hospitalmanagement.hospitalmng.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hospitalmanagement.hospitalmng.Entity.TakeAppointment;
import hospitalmanagement.hospitalmng.Repository.TakeAppointmentRepo;
import hospitalmanagement.hospitalmng.Servies.TakeAppointmentService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin("*")
public class TakeAppointmentController {

    @Autowired
    private TakeAppointmentService takeAppointmentService;

    @Autowired
    private TakeAppointmentRepo takeAppointmentRepo;

    @GetMapping("/viewAllAppointment")
    List<TakeAppointment> GetAllAppiontment() {
        return takeAppointmentService.GetAllAppiontment();
    }

    @PostMapping("/takeAppointment")
    ResponseEntity<TakeAppointment> createTakeAppointment(@RequestBody TakeAppointment infAppointment) {
        return ResponseEntity.ok(takeAppointmentService.CreteTakeAppointment(infAppointment));
    }

    @PutMapping("/takeAppointmentUpdate")
    ResponseEntity<TakeAppointment> updateTakeAppointment(@RequestBody TakeAppointment infAppointment) {
        return ResponseEntity.ok(takeAppointmentService.updateTakeAppointment(infAppointment));
    }

    @GetMapping("/patient/{pid}")
    public ResponseEntity<List<TakeAppointment>> getAppintmentByuserId(@PathVariable Long pid) {
        return ResponseEntity.ok(takeAppointmentService.getAppointmentByUserId(pid));
    }

    @PostMapping("/cancelAppointment/{Appointmentid}")
    public String postMethodName(@PathVariable Long Appointmentid) {
        System.out.println(Appointmentid);
        TakeAppointment appointment = takeAppointmentRepo.findById(Appointmentid).orElseThrow();
        appointment.setCancelStatus(true);
        takeAppointmentRepo.save(appointment);
        return "Appointment cancel successfully..";
    }

}
