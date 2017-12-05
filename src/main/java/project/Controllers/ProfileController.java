package project.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import project.Database.Employee;
import project.Database.User;
import project.Database.Customer;
import project.Repositories.CustomerRepository;
import project.Repositories.EmployeeRepository;
import project.Repositories.UserRepository;

@Controller
public class ProfileController {
	@Autowired
	private UserRepository userRep;

	@Autowired
	private CustomerRepository customerRep;

	@Autowired
	private EmployeeRepository employeeRep;

	static long id;

	@GetMapping(path = "/customerProfile/update")
	public String changeCustomerInfo(@RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String email, @RequestParam String password, @RequestParam String driversLicense) {

		User u = userRep.findOne(id);
		u.setFirstName(firstName);
		u.setLastName(lastName);
		u.setEmail(email);
		u.setPassword(password);
		userRep.save(u);

		Customer c = customerRep.findByUserId(id);
		c.setDriversLicense(driversLicense);
		customerRep.save(c);

		return "redirect:/customerProfile";
	}

	@GetMapping(path = "/employeeProfile/update")
	public String changeEmployeeInfo(@RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String email, @RequestParam String password, @RequestParam String passCode) {

		User u = userRep.findOne(id);
		u.setFirstName(firstName);
		u.setLastName(lastName);
		u.setEmail(email);
		u.setPassword(password);
		userRep.save(u);

		Employee e = employeeRep.findByUserId(id);
		e.setPassCode(passCode);
		employeeRep.save(e);

		return "redirect:/employeeProfile";
	}

	@GetMapping(path = "employeeProfile")
	public String showEmployeeInfo(Model model) {

		model.addAttribute("emp", userRep.findOne(id));
		model.addAttribute("empPass", employeeRep.findByUserId(id));
		return "employeeProfile";
	}

	@GetMapping(path = "customerProfile")
	public String showCustomerInfo(Model model) {
		model.addAttribute("cust", userRep.findOne(id));
		model.addAttribute("custDr", customerRep.findByUserId(id));

		return "customerProfile";
	}
}
