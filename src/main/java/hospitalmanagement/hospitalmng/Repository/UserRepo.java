package hospitalmanagement.hospitalmng.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hospitalmanagement.hospitalmng.Entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String username);

    @Query("SELECT u FROM User u WHERE u.role = 'Patient'")
    List<User> findAllPatients();

    @Query("SELECT u FROM User u WHERE u.role = 'Doctor'")
    List<User> findAllDoctors();

}
