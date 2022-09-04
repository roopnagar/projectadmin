package userregistration.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import userregistration.dao.UserRepository;
import userregistration.entities.User;
import userregistration.exceptions.InvalidCredentialExceptions;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User getUserById(Long userId) {
		Optional<User> user = userRepo.findById(userId);
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}

	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User updateUser(User user) {
		if (userRepo.existsById(user.getUserId())) {
			return userRepo.save(user);
		} else {
			return null;
		}
	}

	@Override
	public void deleteUserById(Long userId) {
		userRepo.deleteById(userId);

	}

	@Override
	public User loginUser(User user) throws InvalidCredentialExceptions {
        User usr = userRepo.findByUsername(user.getUsername());
        if(usr!= null) {
            if(usr.getPassword().equals(user.getPassword() )) {
                
                return usr;
            }else {
                throw new InvalidCredentialExceptions();
            }
        }else {
            throw new InvalidCredentialExceptions();
        }
        
    }

	@Override
	public User updateByAdmins(User user) {
		
		if (userRepo.existsById(user.getUserId())) {
			return userRepo.save(user);
		} else {
			return null;
		}
	}

}
