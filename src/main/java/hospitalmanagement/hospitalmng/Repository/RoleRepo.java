package hospitalmanagement.hospitalmng.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hospitalmanagement.hospitalmng.Entity.Role;

public interface RoleRepo extends JpaRepository <Role,Long> 
{
    
}
