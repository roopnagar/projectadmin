package userregistration.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import userregistration.entities.User;
import userregistration.entities.UserDetails;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetails, Long> {

	User findByEmail(String email);
}
