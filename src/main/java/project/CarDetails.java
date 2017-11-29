package project;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CarDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String VIN;

    private String Make, Model, Year, Color, Price, MPG;


    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String name) {
        this.Make = name;
    }

    public String getModel() {
        return Model;
    }

    public void setModel (String last) {
        this.Model = last;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String y) {
        this.Year = y;
    }

    public String getColor(){return Color;}
    public String getPrice() {return Price;}
    public String getMPG() {return MPG;}

    public void setColor(String c) {this.Color = c;}
    public void setPrice(String p ) {this.Price = p;}
    public void setMPG(String M) {this.MPG = M;}

}
