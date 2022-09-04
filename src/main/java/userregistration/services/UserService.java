package userregistration.services;

import userregistration.entities.User;
import userregistration.exceptions.InvalidCredentialExceptions;

public interface UserService {
	
	//retrieve
		public User getUserById(Long userId);
		//create
		public User addUser(User user);
		//update
		public User updateUser(User user);
		//delete
		public void deleteUserById(Long userId);
		public User loginUser(User user) throws InvalidCredentialExceptions;
		public User updateByAdmins(User user);
		
		

}
