package userregistration.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import userregistration.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	
	

}
