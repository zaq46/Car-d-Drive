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
import project.Database.Employee;

import project.Repositories.EmployeeRepository;



@Controller 
public class EmpSignupController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
 
	public static long id;
	
	
	@GetMapping(path = "/empSignup")
	public String add(){
		
		Employee e = new Employee();
		e.setUserId(id);
		employeeRepository.save(e);
		
		return "mainemployee";
	}
	
	

}
