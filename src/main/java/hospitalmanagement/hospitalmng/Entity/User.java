package hospitalmanagement.hospitalmng.Entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class User implements UserDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    // @JsonIgnore
    private String password;
    private String usergender;
    private String bloodgroup;
    private String contactNo;
    private String age;
    private String street;
    private String city;
    private String role;
    private String experience;
    private String Specialist;
    private int pincode;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private String image;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() 
    {
       return null;
    }
    @Override
    public String getUsername() {
      
      return this.email;
        
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
      return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
         return true;
    }
    @Override
    public boolean isEnabled() {
         return true;
    }


}
