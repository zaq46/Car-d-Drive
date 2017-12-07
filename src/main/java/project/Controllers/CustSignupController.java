package project.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import groovy.lang.Grab;
import project.Database.Customer;
import project.Repositories.CustomerRepository;

@Controller
public class CustSignupController {

	@Autowired
	private CustomerRepository customerRepository;

	public static long id;

	@GetMapping(path = "/custSignup")
	public String add() {

		Customer c = new Customer();
		c.setUserId(id);
		customerRepository.save(c);

		return "redirect:/main";
	}

}
