package userregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import userregistration.entities.User;
import userregistration.entities.UserDetails;
import userregistration.services.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/registration")
	public String showRegistrationForm(@ModelAttribute("user") User user, @ModelAttribute("userdetails") UserDetails userDetails) {
		return "registration";
	}
	
	@PostMapping("/saveuser")
	public ModelAndView saveUser(@ModelAttribute("user") User user, @ModelAttribute("userdetails") UserDetails userdetails) {
		user.setUserDetails(userdetails);
		ModelAndView mv = new ModelAndView();
		User use = userService.addUser(user);
		mv.addObject("userData", use);
		mv.setViewName("registration");
		return mv;	
	}

}
