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
import project.Database.User;
import project.Database.Vehicle;
import project.Repositories.CustomerRepository;
import project.Repositories.EmployeeRepository;
import project.Repositories.UserRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/login") // This means URL's start with /carDrive
public class LoginController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EmployeeRepository empRep;

	@GetMapping(path = "/validate")
	public String validateUser(@RequestParam String email, @RequestParam String password) {

		for (User u : userRepository.findAll()) {

			if (email.equals(u.getEmail()) && password.equals(u.getPassword())) {
				ProfileController.id = u.getId();

				if (empRep.findByUserId(u.getId()) != null) {
					return "redirect:/mainemployee";
				}

				return "redirect:/main";
			}
		}
		return "index";
	}

}