package userregistration.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import userregistration.entities.User;
import userregistration.entities.UserDetails;
import userregistration.exceptions.InvalidCredentialExceptions;
import userregistration.services.UserDetailsService;
import userregistration.services.UserService;

@Controller
public class AdminController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserDetailsService userDetailsService;
	

	@GetMapping("/admin")
	public String loginAdmin(@ModelAttribute("user") User user) {
		return "admin";
	}

	@GetMapping("/update")
	public String showUpdateForm(@ModelAttribute("user") User user,
			@ModelAttribute("userdetails") UserDetails userDetails) {
		return "adminupdate";
	}

	@PutMapping("/updateadmin")
	public ModelAndView updateByAdmin(@ModelAttribute("user") User user,
			@ModelAttribute("userdetails") UserDetails userDetails) {

		user.setUserDetails(userDetails);
		ModelAndView mv = new ModelAndView();
		User us = userService.updateByAdmins(user);
		mv.setViewName("adminupdate");
		mv.addObject("updateAdmin", us);
		return mv;
	}

	@PostMapping("/adminup")
	public ModelAndView loginUser(@ModelAttribute("user") User user) {
		User usr;
		ModelAndView mv = new ModelAndView();
		try {
			usr = userService.loginUser(user);
			mv.addObject("userData", usr);
			mv.setViewName("loggedadmin");

		} catch (InvalidCredentialExceptions e) {
			mv.addObject("errormsg", "Username or Password incorrect");
			mv.setViewName("loggedadmin");
		}

		return mv;
	}

	@GetMapping("/delete")
	public String delete(@ModelAttribute("user") User user, @ModelAttribute("userdetails") UserDetails userdetails) {
		return "delete";
	}

	@DeleteMapping("/deleteuser")
	public ModelAndView deletesUser(@ModelAttribute("user") User user) {

		userService.deleteUserById(user.getUserId());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("delete");
		mv.addObject("msg", "Deleted Successfully");
		return mv;

	}
	
	@GetMapping("/list")
	public ModelAndView listOfUser(@ModelAttribute("userdetails") UserDetails userdetails) {
		ModelAndView mv = new ModelAndView();
		List<UserDetails> users = userDetailsService.getList();
		mv.setViewName("list");
		mv.addObject("listOfUsers", users);
		return mv;
	}
	
	

}
