package userregistration.services;

import userregistration.entities.Role;

public interface RoleService {
	//retrieve
	public Role getRoleById(Long id);
	//create
	public Role addRole(Role role);
	//update
	public Role updateRole(Role role);
	//delete
	public void deleteRoleById(Long id);
	
	

}
