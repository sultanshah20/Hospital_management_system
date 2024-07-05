package hospitalmanagement.hospitalmng.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import hospitalmanagement.hospitalmng.Entity.User;
import hospitalmanagement.hospitalmng.Repository.UserRepo;
import hospitalmanagement.hospitalmng.Servies.UserRegisterService;
import io.jsonwebtoken.io.IOException;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserRegisterService registerService;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/register")
    ResponseEntity<User> CreateAdmin(@RequestBody User register) {

        return ResponseEntity.ok(registerService.CreateAdmin(register));
    }

    @GetMapping("/getAllpatients")
    ResponseEntity<List<User>> findAllPatients() {
        return ResponseEntity.ok(registerService.findAllPatients());
    }

    @GetMapping("/getAllDoctors")
    ResponseEntity<List<User>> findAllDoctors() {
        return ResponseEntity.ok(registerService.findAllDoctors());
    }

    @DeleteMapping("/patient/{patientId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long patientId) {
        if (registerService.DeletePatientById(patientId)) {
            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getuser/{userid}")
    public User getUserById(@PathVariable Long userid) {
        return registerService.getUserById(userid);
    }

    // image upload

    @PostMapping("/uploadImage")
    public String uploadImage(@RequestBody MultipartFile imageFile) throws java.io.IOException {
        try {
            // Get the image bytes
            byte[] imageBytes = imageFile.getBytes();
            // Process the image bytes (e.g., save to a file, store in the database)
            // Example:
            // Files.write(Paths.get("path/to/save/image.jpg"), imageBytes);

            return "Image uploaded successfully";
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
            return "Error uploading image: " + e.getMessage();
        }
    }

    @PostMapping("/update/userDetails")
    public ResponseEntity<User> updateUserDetails(@RequestBody User user) {
        System.out.println(user.getId());
        User byIduserDetailsOptional = userRepo.findById(user.getId()).orElseThrow();
        //  user.setId(12);
        System.out.println("run............");
        byIduserDetailsOptional.setFirstName(user.getFirstName());
        byIduserDetailsOptional.setLastName(user.getLastName());
        byIduserDetailsOptional.setExperience(user.getExperience());
        byIduserDetailsOptional.setSpecialist(user.getSpecialist());
        byIduserDetailsOptional.setImage(user.getImage());
        return ResponseEntity.ok(registerService.updateUser(byIduserDetailsOptional));
    }

}
