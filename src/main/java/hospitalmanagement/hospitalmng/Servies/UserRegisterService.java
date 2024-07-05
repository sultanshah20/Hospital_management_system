package hospitalmanagement.hospitalmng.Servies;


import java.util.List;

import org.springframework.stereotype.Service;

import hospitalmanagement.hospitalmng.Entity.User;

@Service
public interface UserRegisterService 
{
  
    User CreateAdmin(User register);

    // findAllpatient
    
    List<User> findAllPatients();
    
    // findAllDoctor
    List<User> findAllDoctors();


   // Delete patient from id
   boolean DeletePatientById(Long id);

//  update
   User updateUser(User user);

// get single user
User getUserById(Long userid);
}
