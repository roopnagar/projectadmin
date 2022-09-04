package userregistration.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import userregistration.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	
	User findByUsername(String username);
	
	

}