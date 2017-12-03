package project.Database;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String vehicleVin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVin() {
		return vehicleVin;
	}

	public void setVin(String vehicle) {
		this.vehicleVin = vehicle;

	}

	private String doorType;

	public String getDoorType() {
		return doorType;
	}

	public void setDoorType(String doorType) {
		this.doorType = doorType;
	}
}
