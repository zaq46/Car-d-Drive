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
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String total;

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	
	@JoinColumn(name = "vehicleVin")
	@Column(name = "vehicleVin")
	private Vehicle vehicle;
	
	public Vehicle getVin() {
		return vehicle;
	}

	public void setVin(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@JoinColumn(name = "userId")
	@Column(name = "userId")
	private User userId;

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}
}
