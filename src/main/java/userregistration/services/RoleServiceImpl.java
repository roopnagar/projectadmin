package userregistration.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import userregistration.dao.RoleRepository;
import userregistration.entities.Role;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepo;

	@Override
	public Role getRoleById(Long id) {
		Optional<Role> role = roleRepo.findById(id);
		if (role.isPresent()) {
			return role.get();
		} 
			return null;
		
	}

	@Override
	public Role addRole(Role role) {
		return roleRepo.save(role);
	}

	@Override
	public Role updateRole(Role role) {
		if (roleRepo.existsById(role.getId())) {
			return roleRepo.save(role);
		} 
			return null;
		
	}

	@Override
	public void deleteRoleById(Long id) {
		roleRepo.deleteById(id);

	}

}
