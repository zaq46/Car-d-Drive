package project.Database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

private Long id;
private String make, model, year, color, price, mpg, vin;

public String getVin() {
	return vin;
}
public void setVin(String vin) {
	this.vin = vin;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getMake() {
	return make;
}
public void setMake(String make) {
	this.make = make;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public String getYear() {
	return year;
}
public void setYear(String year) {
	this.year = year;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getMpg() {
	return mpg;
}
public void setMpg(String mpg) {
	this.mpg = mpg;
}

}
	

