package project.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import project.Database.User;
import project.Database.Vehicle;
import project.Repositories.UserRepository;

@Controller // This means that this class is a Controller
// @RequestMapping(path="/carDrive") // This means URL's start with /carDrive
public class MainController {
	@Autowired // This means to get the bean called userRepository
				// Which is auto-generated by Spring, we will use it to handle
				// the data
	private UserRepository userRepository;

	@GetMapping(path = "/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser(@RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String email, @RequestParam String pass) {
		// @ResponseBody means the returned String is the response, not a view
		// name
		// @RequestParam means it is a parameter from the GET or POST request

		User n = new User();
		n.setFirstName(firstName);
		n.setLastName(lastName);
		n.setEmail(email);
		n.setPassword(pass);
		userRepository.save(n);
		return "Saved";
	}

	@RequestMapping(value = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}

	@RequestMapping(value = "/homepage/listallusers")
	public String getalluers(Model model) {

		model.addAttribute("users", userRepository.findAll());
		return "userresult";
	}


	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String usersList(Model model) {
		model.addAttribute("users", userRepository.findAll());
		// provides an iterated list that allows us to use it in thymeleaf

		return "users";
		// this maps to corresponding .html file
		// with the same name
	}

	@RequestMapping(value = "/user/remove/{id}", method = RequestMethod.DELETE)
	public String removeUser(@PathVariable(value = "id") long userID) {
		// User user = userRepository.findOne(userID); // return user to delete
		// userRepository.delete(user); // delete returned user

		userRepository.delete(userID); // delete user from given userID
										// parameter
		return "redirect:/users";
		// return "good luck my friend";

	}

	@GetMapping(path = "/homepage/")
	public String homepage() {
		// model.addAttribute("name", name);
		return "main";
		// return "main";
	}

	/*@GetMapping(path = "/homepage/redirect")
	public String redircect() {
		// model.addAttribute("name", name);
		return "homepage";
		// return "main";
	}*/

	/*@GetMapping(path = "/homepage/employeeredirect")
	public String employeeredircect() {
		// model.addAttribute("name", name);
		return "homepageemployee";
		// return "main";
	}*/

	@RequestMapping(value = "/homepage/searchresultsemployee")
	public String displayuser(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
			@RequestParam("email") String email, Model model) {

		ArrayList<User> list = new ArrayList<User>();
		// enhanced for loop for searching users that satisfy all conditions.
		for (User u : userRepository.findAll()) {
			if (firstname.isEmpty() && lastname.isEmpty() && email.isEmpty()) {
				return "homepage/employeeredirect";
			}
			if (!firstname.isEmpty()) {
				if (!firstname.equals(u.getFirstName())) {
					continue;
				}
			}
			if (!lastname.isEmpty()) {
				if (!lastname.equals(u.getLastName())) {
					continue;
				}
			}
			if (!email.isEmpty()) {
				if (!email.equals(u.getEmail())) {
					continue;
				}
			}
			list.add(u);
		}
		model.addAttribute("users", list);
		return "userresult";
	}

	// model.addAttribute("users",userRepository.findByLastName(lastname));
	// if(firstname != "" && lastname != "" && email == "")
	// {
	// model.addAttribute("users",
	// userRepository.findByFirstNameAndLastName(firstname, lastname));
	// }
	//
	// if(firstname != "" && lastname != "" && email != "")
	// {
	// model.addAttribute("users",
	// userRepository.findByFirstNameAndLastNameAndEmail(firstname, lastname,
	// email));
	// }
	//
	// if(firstname != "" && lastname == "" && email == "")
	// {
	// model.addAttribute("users", userRepository.findByFirstName(firstname));
	// }
	//
	// if(firstname == "" && lastname != "" && email == "")
	// {
	// model.addAttribute("users", userRepository.findByLastName(lastname));
	// }
	//
	// if(firstname == "" && lastname == "" && email != "")
	// {
	// model.addAttribute("users", userRepository.findByEmail(email));
	// }
	//
	// return "userresult" ;
}
