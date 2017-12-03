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
							 @RequestParam("mpg") String mpgquery,
							 Model model) {
		Vehicle v = new Vehicle();
		//vehicleRepository.deleteAll();
		//model.addAttribute("vehicles", vehicleRepository.findByMpg(mpgquery));
		//model.addAttribute("vehicles", vehicleRepository.findByAllFields(makequery, modelquery, yearquery));

		if (vinquery != "" & makequery != "" & modelquery != "" & yearquery != "" & pricequery != "" &
				colorquery != "" & mpgquery != "")
		{
			model.addAttribute("vehicles", vehicleRepository.findByMakeAndModelAndYearAndPriceAndColorAndMpgAndVin(makequery, modelquery, yearquery, pricequery,
					colorquery, mpgquery, vinquery));
		}
		if (vinquery != "" & makequery == "" & modelquery == "" & yearquery == "" & pricequery == "" &
				colorquery == "" & mpgquery == "")
		{
			model.addAttribute("vehicles", vehicleRepository.findByVin(vinquery));
		}

		if (vinquery == "" & makequery != "" & modelquery == "" & yearquery == "" & pricequery == "" &
				colorquery == "" & mpgquery == "")
		{
			model.addAttribute("vehicles", vehicleRepository.findByMake(makequery));
		}

		if (vinquery == "" & makequery == "" & modelquery != "" & yearquery == "" & pricequery == "" &
				colorquery == "" & mpgquery == "")
		{
			model.addAttribute("vehicles", vehicleRepository.findByModel(modelquery));
		}

		if (vinquery == "" & makequery == "" & modelquery == "" & yearquery != "" & pricequery == "" &
				colorquery == "" & mpgquery == "")
		{
			model.addAttribute("vehicles", vehicleRepository.findByYear(yearquery));
		}
		if (vinquery == "" & makequery == "" & modelquery == "" & yearquery == "" & pricequery != "" &
				colorquery == "" & mpgquery == "")
		{
			model.addAttribute("vehicles", vehicleRepository.findByPrice(yearquery));
		}

		if (vinquery == "" & makequery != "" & modelquery != "" & yearquery != "" & pricequery == "" &
				colorquery == "" & mpgquery == "")
		{
			model.addAttribute("vehicles", vehicleRepository.findByMakeAndModelAndYear(makequery, modelquery, yearquery));
		}



       /* if (vinquery != "") {
            model.addAttribute("vehicles", vehicleRepository.findByVin(vinquery));
        }
        else if (makequery != "") {
            model.addAttribute("vehicles", vehicleRepository.findByMake(makequery));
        }
        else if(modelquery != "") {
            model.addAttribute("vehicles", vehicleRepository.findByModel(modelquery));
        }
        else if(yearquery != "") {
            model.addAttribute("vehicles", vehicleRepository.findByYear(yearquery));
        }
        else if(pricequery != "") {
            model.addAttribute("vehicles", vehicleRepository.findByPrice(pricequery));
        }
        else if(colorquery != "") {
            model.addAttribute("vehicles", vehicleRepository.findByColor(colorquery));
        }
        else if(mpgquery != "") {
            model.addAttribute("vehicles", vehicleRepository.findByMpg(mpgquery));
        }*/

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

           model.addAttribute("vehicles", vehicleRepository.findByMake(makequery));
           model.addAttribute("vehicles", vehicleRepository.findByModel(modelquery));

           model.addAttribute("vehicles", vehicleRepository.findByColor(yearquery));
           model.addAttribute("vehicles", vehicleRepository.findByMpg(pricequery));

           model.addAttribute("vehicles", vehicleRepository.findByPrice(colorquery));
           model.addAttribute("vehicles", vehicleRepository.findByYear(mpgquery));*/


			//System.out.println("TEST");
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
