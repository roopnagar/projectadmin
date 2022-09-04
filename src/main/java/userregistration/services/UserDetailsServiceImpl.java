package userregistration.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import userregistration.dao.UserDetailsRepository;
import userregistration.entities.UserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDetailsRepository userDetailsRepo;

	@Override
	public UserDetails addUser(UserDetails userDetails) {
		// TODO Auto-generated method stub
		return userDetailsRepo.save(userDetails);
	}

	@Override
	public UserDetails getUserById(Long id) {
		Optional<UserDetails> userDetails = userDetailsRepo.findById(id);
		if (userDetails.isPresent()) {
			return userDetails.get();
		} else {
			return null;
		}
	}

	@Override
	public UserDetails updateUser(UserDetails userDetails) {
		if (userDetailsRepo.existsById(userDetails.getId())) {
			return userDetailsRepo.save(userDetails);
		} else {
			return null;
		}
	}

	@Override
	public void deleteUserById(Long id) {
		userDetailsRepo.deleteById(id);

	}

	@Override
	public List<UserDetails> getList() {
		// TODO Auto-generated method stub
		return (List<UserDetails>) userDetailsRepo.findAll();
	}

}
