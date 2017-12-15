package project.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import groovy.lang.Grab;
import project.Database.HasUser;
import project.Database.User;
import project.Repositories.UserRepository;
import project.Repositories.HasUserRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/employeeSignup") // This means
public class EmployeeSignupController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private HasUserRepository hasUserRep;

	@GetMapping(path = "/add")
	public @ResponseBody ModelAndView addNewUser(@RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String email, @RequestParam String password) {
		ModelAndView modelAndView = new ModelAndView();
		if (email.contains("@") && password.length() > 4) {
			User n = new User();
			n.setFirstName(firstName);
			n.setLastName(lastName);
			n.setEmail(email);
			n.setPassword(password);
			userRepository.save(n);
			modelAndView.setViewName("redirect:/empSignup");
			EmpSignupController.id = n.getId();
			ProfileController.id =  n.getId();
			
			HasUser h = new HasUser();
			h.setUserId(n.getId());
			h.setAddress("1 Washington Sq");
			hasUserRep.save(h);
			return modelAndView;
		}
		System.out.println("invalid email or password");
		modelAndView.setViewName("signup");
		return modelAndView;

	}

}
