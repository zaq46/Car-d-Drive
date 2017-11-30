package project.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import project.Database.Vehicle;
import project.Repositories.VehicleRepository;


@Controller
public class VehicleController {
	@Autowired
	private VehicleRepository vehicleRepository;

	@RequestMapping(value = "/bam")
	public String addVehicle(Model model) {
		model.addAttribute("vehicles", vehicleRepository.findByColor("blue"));

		//need to implement switch statement for search by color, make, model, year.....
		//need to implement check box to ask users what they search by
		
		return "bam";

	}

}
