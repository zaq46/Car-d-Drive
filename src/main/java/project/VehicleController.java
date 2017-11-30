package project;

import java.util.LinkedList;

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

import project.Vehicle;
import project.VehicleRepository;

@Controller
public class VehicleController {
	@Autowired
	private VehicleRepository vehicleRepository;

	@RequestMapping(value = "/bam")
	public String addVehicle(Model model) {
		model.addAttribute("vehicles", vehicleRepository.findByColor("blue"));

		return "bam";

	}

	// @RequestMapping(value = "bam")
	// public String searchVehicle(@RequestParam("q") String key, Model model){
	//
	// LinkedList<Vehicle> v = new LinkedList<>();
	// for(int i =0; i<vehicleRepository.count(); i++){
	// v.add(vehicleRepository.SearchByKeyword(key));
	//
	// }
	//
	// return "sss";
	// }

}
