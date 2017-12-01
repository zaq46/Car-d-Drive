package project.Controllers;
import java.sql.*;



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

import project.Database.Vehicle;
import project.Repositories.VehicleRepository;


@Controller
public class VehicleController {
	@Autowired
	private VehicleRepository vehicleRepository;


	@RequestMapping(value = "/homepage/searchresults")
	public String addVehicle(@RequestParam("vin") String vinquery, @RequestParam("make") String makequery,
                             @RequestParam("model") String modelquery,@RequestParam("year") String yearquery,
                             @RequestParam("price") String pricequery,@RequestParam("color") String colorquery,
                             @RequestParam("mpg") String mpgquery, Model model) {
	    Vehicle v = new Vehicle();
	    //vehicleRepository.deleteAll();

        try{
            /*Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/CarDrive","springuser","4MhWX$A&*9$v");
            //here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
            // THISWORKS
            // ResultSet rs=stmt.executeQuery("select * from car_details WHERE make = '" + queryresult + "'");
            ResultSet rs=stmt.executeQuery("select * from car_details WHERE make = '" + queryresult + "'" +
                    " OR model = '" + queryresult + "'" + " OR year = '" + queryresult + "'" + " OR color = '" + queryresult + "'"
                    + " OR vin = '" + queryresult + "'" + " OR price = '" + queryresult + "'" + " OR mpg = '" + queryresult + "'");

            //ResultSet rs=stmt.executeQuery("select * from car_details WHERE make LIKE '" + "%" + queryresult + "%" + "'");

            while(rs.next()) {

                String id = rs.getString("vin");
                String firstName = rs.getString("color");
                String lastName = rs.getString("mpg");
                String dateCreated = rs.getString("make");
                String isAdmin = rs.getString("model");
                String numPoints = rs.getString("price");


                // print the results
                System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);

                v.setVin(rs.getString("vin"));
                v.setColor(rs.getString("color"));
                v.setMpg(rs.getString("mpg"));
                v.setMake(rs.getString("make"));
                v.setModel(rs.getString("model"));
                v.setPrice(rs.getString("price"));
                v.setYear(rs.getString("year"));

                vehicleRepository.save(v);

                //con.close();
            }*/

           // model.addAttribute("vehicles", vehicleRepository.findAll());
            //model.addAttribute("cd", userRepository.findAll());
           /* model.addAttribute("vehicles", vehicleRepository.findByVin(vinquery));

           model.addAttribute("vehicles", vehicleRepository.findByMake(queryresult));
           model.addAttribute("vehicles", vehicleRepository.findByModel(queryresult));

           model.addAttribute("vehicles", vehicleRepository.findByColor(queryresult));
           model.addAttribute("vehicles", vehicleRepository.findByMpg(queryresult));

           model.addAttribute("vehicles", vehicleRepository.findByPrice(queryresult));
           model.addAttribute("vehicles", vehicleRepository.findByYear(queryresult));*/


           System.out.println("TEST");
           //System.out.println(vehicleRepository.findByMake(queryresult));


        }catch(Exception e){
            System.out.println(e);

        }


		//model.addAttribute("vehicles", vehicleRepository.findByColor("blue"));

		//need to implement switch statement for search by color, make, model, year.....
		//need to implement check box to ask users what they search by
		
		return "bam";

	}

}
