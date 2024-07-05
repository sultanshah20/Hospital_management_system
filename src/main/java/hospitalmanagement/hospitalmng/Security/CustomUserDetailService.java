package hospitalmanagement.hospitalmng.Security; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hospitalmanagement.hospitalmng.Entity.User;
import hospitalmanagement.hospitalmng.Repository.UserRepo;


@Service
public class CustomUserDetailService implements UserDetailsService{

      @Autowired
      private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //    loading user from databases by username
      User user = this.userRepo.findByEmail(username).orElseThrow();
        //  User user=this.userRepo.findByUsername(username).orElse(null);
        return (UserDetails) user;
    }

    
    
}