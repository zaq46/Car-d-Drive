package project;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import project.Vehicle;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
	
	public Iterable<Vehicle> findByColor(String key);
}
