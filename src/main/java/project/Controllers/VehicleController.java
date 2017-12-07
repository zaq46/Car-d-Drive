package project.Controllers;

import java.sql.*;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;

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

import groovy.lang.DelegatesTo.Target;
import project.Database.Car;
import project.Database.Ev;
import project.Database.Motorcycle;
import project.Database.Truck;
import project.Database.Vehicle;
import project.Repositories.CarRepository;
import project.Repositories.EvRepository;
import project.Repositories.MotercycleRepository;
import project.Repositories.TruckRepository;
import project.Repositories.VehicleRepository;

@Controller

public class VehicleController {
	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private CarRepository carRep;

	@Autowired
	private EvRepository evRep;

	@Autowired
	private MotercycleRepository motRep;

	@Autowired
	private TruckRepository truckRep;


	@RequestMapping(value = "/homepage/listall")
	public String searchVehicle(Model model) {

		model.addAttribute("vehicles", vehicleRepository.findAll());
		return "bam";

	}



	@RequestMapping(value = "/homepage/searchresults")
	public String searchVehicle(@RequestParam("vin") String vinquery, @RequestParam("make") String makequery,
								@RequestParam("model") String modelquery, @RequestParam("year") String yearquery,
								@RequestParam("price") String pricequery, @RequestParam("color") String colorquery,
								@RequestParam("mpg") String mpgquery, Model model) {

		ArrayList<Vehicle> list = new ArrayList<Vehicle>();
		// enhanced for loop for searching vehicles that satisfy all conditions.
		for (Vehicle v : vehicleRepository.findAll()) {

			if (vinquery.isEmpty() && makequery.isEmpty() && modelquery.isEmpty() && yearquery.isEmpty()
					&& pricequery.isEmpty() && colorquery.isEmpty() && mpgquery.isEmpty()) {
				return "bam";
			}
			if (!vinquery.isEmpty()) {
				if (!vinquery.equals(v.getVin())) {
					continue;
				}
			}
			if (!makequery.isEmpty()) {
				if (!makequery.equals(v.getMake())) {
					continue;

				}
			}
			if (!modelquery.isEmpty()) {
				if (!modelquery.equals(v.getModel())) {
					continue;
				}
			}
			if (!yearquery.isEmpty()) {
				if (!yearquery.equals(v.getYear())) {
					continue;
				}
			}
			if (!pricequery.isEmpty()) {
				if (!pricequery.equals(v.getPrice())) {
					continue;
				}
			}
			if (!colorquery.isEmpty()) {
				if (!colorquery.equals(v.getColor())) {
					continue;
				}
			}
			if (!mpgquery.isEmpty()) {
				if (!mpgquery.equals(v.getMpg())) {
					continue;
				}
			}

			list.add(v);

		}

		model.addAttribute("vehicles", list);
		return "bam";

	}

    //adds a car entry as well as an entry for general vehicle
	@RequestMapping(value = "carAdd")
	public String addCar(@RequestParam("vin") String vin, @RequestParam("make") String make,
						 @RequestParam("model") String model, @RequestParam("year") String year,
						 @RequestParam("price") String price, @RequestParam("color") String color,
						 @RequestParam("mpg") String mpg, @RequestParam("door-type") String doorType){

		//save the input into vehicle repo
		saveVehicle(vin, make, model, year, price, color, mpg);

		//save attributes into car repo
		Car c = new Car();
		c.setVin(vin);
		c.setDoorType(doorType);
		carRep.save(c);
		return "redirect:/vehicleEntry";
	}

    //adds a truck entry as well as an entry for general vehicle
	@RequestMapping(value = "truckAdd")
    public String addTruck(@RequestParam("vin") String vin, @RequestParam("make") String make,
                           @RequestParam("model") String model, @RequestParam("year") String year,
                           @RequestParam("price") String price, @RequestParam("color") String color,
                           @RequestParam("mpg") String mpg, @RequestParam("horsepower") String horsePower,
                           @RequestParam("size") String size){
        saveVehicle(vin, make, model, year, price, color, mpg);

        Truck t = new Truck();
        t.setVin(vin);
        t.setSize(size);
        t.setHorsepower(horsePower);
        truckRep.save(t);
	    return "redirect:/vehicleEntry";
    }

    //adds a motorcycle entry as well as an entry for general vehicle
    @RequestMapping(value = "motorcycleAdd")
    public String addMotorcycle(@RequestParam("vin") String vin, @RequestParam("make") String make,
                           @RequestParam("model") String model, @RequestParam("year") String year,
                           @RequestParam("price") String price, @RequestParam("color") String color,
                           @RequestParam("mpg") String mpg, @RequestParam("style") String style){
        saveVehicle(vin, make, model, year, price, color, mpg);

        Motorcycle m = new Motorcycle();
        m.setVin(vin);
        m.setStyle(style);
        motRep.save(m);
        return "redirect:/vehicleEntry";
    }

    //adds a EV entry as well as an entry for general vehicle
    @RequestMapping(value = "evAdd")
    public String addEv(@RequestParam("vin") String vin, @RequestParam("make") String make,
                                @RequestParam("model") String model, @RequestParam("year") String year,
                                @RequestParam("price") String price, @RequestParam("color") String color,
                                @RequestParam("mpg") String mpg, @RequestParam("batteryLife") String batteryLife){
        saveVehicle(vin, make, model, year, price, color, mpg);

        Ev x = new Ev();
        x.setVin(vin);
        x.setBatteryLife(batteryLife);
        evRep.save(x);
        return "redirect:/vehicleEntry";
    }
    //possible redundant or obselete as of 4pm 12/6/17
	@RequestMapping(value = "/vehicleAdd")
	public String addVehicle(@RequestParam("vin") String vin, @RequestParam("make") String make,
							 @RequestParam("model") String model, @RequestParam("year") String year, @RequestParam("price") String price,
							 @RequestParam("color") String color, @RequestParam("mpg") String mpg, @RequestParam("type") String type) {

		Vehicle v = new Vehicle();
		v.setVin(vin);
		v.setMake(make);
		v.setModel(model);
		v.setYear(year);
		v.setPrice(price);
		v.setColor(color);
		v.setMpg(mpg);
		vehicleRepository.save(v);

		if (type.equals("car")) {
			Car c = new Car();
			c.setVin(vin);
			carRep.save(c);
			return "/carEntry";
		}
		if (type.equals("ev")) {
			Ev c = new Ev();
			c.setVin(vin);
			evRep.save(c);
		}
		if (type.equals("motorcycle")) {
			Motorcycle c = new Motorcycle();
			c.setVin(vin);
			motRep.save(c);
		}
		if (type.equals("truck")) {
			Truck c = new Truck();
			c.setVin(vin);
			truckRep.save(c);
		}

		return "redirect:/vehicleEntry";

	}

	public void saveVehicle(String ve, String ma, String mo, String y,
						String pr, String co, String mpg){
		Vehicle v = new Vehicle();
		v.setVin(ve);
		v.setMake(ma);
		v.setModel(mo);
		v.setYear(y);
		v.setPrice(pr);
		v.setColor(co);
		v.setMpg(mpg);
		vehicleRepository.save(v);
	}

	// @RequestMapping(value = "/vehicle")
	// public String vehicleEntry() {
	// return "vehicleEntry";
	// }
}

// @RequestMapping(value = "/homepage/searchresults")
// public String addVehicle(@RequestParam("vin") String vinquery,
// @RequestParam("make") String makequery,
// @RequestParam("model") String modelquery,@RequestParam("year") String
// yearquery,
// @RequestParam("price") String pricequery,@RequestParam("color") String
// colorquery,
// @RequestParam("mpg") String mpgquery,
// Model model) {
// Vehicle v = new Vehicle();
// //vehicleRepository.deleteAll();
// //model.addAttribute("vehicles", vehicleRepository.findByMpg(mpgquery));
// //model.addAttribute("vehicles", vehicleRepository.findByAllFields(makequery,
// modelquery, yearquery));
//
// if (vinquery != "" & makequery != "" & modelquery != "" & yearquery != "" &
// pricequery != "" &
// colorquery != "" & mpgquery != "")
// {
// model.addAttribute("vehicles",
// vehicleRepository.findByMakeAndModelAndYearAndPriceAndColorAndMpgAndVin(makequery,
// modelquery, yearquery, pricequery,
// colorquery, mpgquery, vinquery));
// }
// if (vinquery != "" & makequery == "" & modelquery == "" & yearquery == "" &
// pricequery == "" &
// colorquery == "" & mpgquery == "")
// {
// model.addAttribute("vehicles", vehicleRepository.findByVin(vinquery));
// }
//
// if (vinquery == "" & makequery != "" & modelquery == "" & yearquery == "" &
// pricequery == "" &
// colorquery == "" & mpgquery == "")
// {
// model.addAttribute("vehicles", vehicleRepository.findByMake(makequery));
// }
//
// if (vinquery == "" & makequery == "" & modelquery != "" & yearquery == "" &
// pricequery == "" &
// colorquery == "" & mpgquery == "")
// {
// model.addAttribute("vehicles", vehicleRepository.findByModel(modelquery));
// }
//
// if (vinquery == "" & makequery == "" & modelquery == "" & yearquery != "" &
// pricequery == "" &
// colorquery == "" & mpgquery == "")
// {
// model.addAttribute("vehicles", vehicleRepository.findByYear(yearquery));
// }
// if (vinquery == "" & makequery == "" & modelquery == "" & yearquery == "" &
// pricequery != "" &
// colorquery == "" & mpgquery == "")
// {
// model.addAttribute("vehicles", vehicleRepository.findByPrice(yearquery));
// }
//
// if (vinquery == "" & makequery != "" & modelquery != "" & yearquery != "" &
// pricequery == "" &
// colorquery == "" & mpgquery == "")
// {
// model.addAttribute("vehicles",
// vehicleRepository.findByMakeAndModelAndYear(makequery, modelquery,
// yearquery));
// }

/*
 * if (vinquery != "") { model.addAttribute("vehicles",
 * vehicleRepository.findByVin(vinquery)); } else if (makequery != "") {
 * model.addAttribute("vehicles", vehicleRepository.findByMake(makequery)); }
 * else if(modelquery != "") { model.addAttribute("vehicles",
 * vehicleRepository.findByModel(modelquery)); } else if(yearquery != "") {
 * model.addAttribute("vehicles", vehicleRepository.findByYear(yearquery)); }
 * else if(pricequery != "") { model.addAttribute("vehicles",
 * vehicleRepository.findByPrice(pricequery)); } else if(colorquery != "") {
 * model.addAttribute("vehicles", vehicleRepository.findByColor(colorquery)); }
 * else if(mpgquery != "") { model.addAttribute("vehicles",
 * vehicleRepository.findByMpg(mpgquery)); }
 */

// try{
/*
 * Class.forName("com.mysql.jdbc.Driver"); Connection
 * con=DriverManager.getConnection(
 * "jdbc:mysql://localhost:3306/CarDrive","springuser","4MhWX$A&*9$v"); //here
 * sonoo is database name, root is username and password Statement
 * stmt=con.createStatement(); // THISWORKS // ResultSet
 * rs=stmt.executeQuery("select * from car_details WHERE make = '" + queryresult
 * + "'"); ResultSet
 * rs=stmt.executeQuery("select * from car_details WHERE make = '" + queryresult
 * + "'" + " OR model = '" + queryresult + "'" + " OR year = '" + queryresult +
 * "'" + " OR color = '" + queryresult + "'" + " OR vin = '" + queryresult + "'"
 * + " OR price = '" + queryresult + "'" + " OR mpg = '" + queryresult + "'");
 * 
 * //ResultSet
 * rs=stmt.executeQuery("select * from car_details WHERE make LIKE '" + "%" +
 * queryresult + "%" + "'");
 * 
 * while(rs.next()) {
 * 
 * String id = rs.getString("vin"); String firstName = rs.getString("color");
 * String lastName = rs.getString("mpg"); String dateCreated =
 * rs.getString("make"); String isAdmin = rs.getString("model"); String
 * numPoints = rs.getString("price");
 * 
 * 
 * // print the results System.out.format("%s, %s, %s, %s, %s, %s\n", id,
 * firstName, lastName, dateCreated, isAdmin, numPoints);
 * 
 * v.setVin(rs.getString("vin")); v.setColor(rs.getString("color"));
 * v.setMpg(rs.getString("mpg")); v.setMake(rs.getString("make"));
 * v.setModel(rs.getString("model")); v.setPrice(rs.getString("price"));
 * v.setYear(rs.getString("year"));
 * 
 * vehicleRepository.save(v);
 * 
 * //con.close(); }
 */

// model.addAttribute("vehicles", vehicleRepository.findAll());
// model.addAttribute("cd", userRepository.findAll());

/*
 * model.addAttribute("vehicles", vehicleRepository.findByVin(vinquery));
 * 
 * model.addAttribute("vehicles", vehicleRepository.findByMake(makequery));
 * model.addAttribute("vehicles", vehicleRepository.findByModel(modelquery));
 * 
 * model.addAttribute("vehicles", vehicleRepository.findByColor(yearquery));
 * model.addAttribute("vehicles", vehicleRepository.findByMpg(pricequery));
 * 
 * model.addAttribute("vehicles", vehicleRepository.findByPrice(colorquery));
 * model.addAttribute("vehicles", vehicleRepository.findByYear(mpgquery));
 */

// System.out.println("TEST");
// System.out.println(vehicleRepository.findByMake(queryresult));

// }catch(Exception e){
// System.out.println(e);
//
// }

// model.addAttribute("vehicles", vehicleRepository.findByColor("blue"));

// need to implement switch statement for search by color, make, model,
// year.....
// need to implement check box to ask users what they search by
//
// return "bam";
//
// }
//
// }
