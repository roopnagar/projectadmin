package userregistration.services;

import java.util.List;

import userregistration.entities.UserDetails;

public interface UserDetailsService {
	
	public UserDetails addUser(UserDetails userDetails);
	//Retrieve
	public UserDetails getUserById(Long id);
	
	//Update
	public UserDetails updateUser(UserDetails userDetails);
	
	//Delete
	public void deleteUserById(Long id);
	
	public List<UserDetails> getList();

}
