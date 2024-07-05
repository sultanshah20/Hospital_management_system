package hospitalmanagement.hospitalmng.Servies.ServiesImp;

import java.net.PasswordAuthentication;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hospitalmanagement.hospitalmng.Entity.User;
import hospitalmanagement.hospitalmng.Repository.UserRepo;
import hospitalmanagement.hospitalmng.Servies.UserRegisterService;

@Service
public class UserRegiserServieImp implements UserRegisterService {
    @Autowired
    private UserRepo registerRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User CreateAdmin(User register) {
        register.setPassword(passwordEncoder.encode(register.getPassword()));
        return registerRepo.save(register);
    }

    @Override
    public List<User> findAllPatients() {
        return registerRepo.findAllPatients();
    }

    @Override
    public List<User> findAllDoctors() {

        return registerRepo.findAllDoctors();
    }

    @Override
    public boolean DeletePatientById(Long id) {

        registerRepo.deleteById(id);
        return true;

    }

    @Override
    public User updateUser(User user) {

        registerRepo.findById(user.getId()).orElseThrow();
        return registerRepo.save(user);
    }

    @Override
    public User getUserById(Long userid) {

        return registerRepo.findById(userid).orElseThrow();
    }

}
