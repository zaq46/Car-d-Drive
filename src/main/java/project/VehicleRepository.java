package project;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import project.Vehicle;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
	
	public Iterable<Vehicle> findByColor(String key);
	public Iterable<Vehicle> findByVin(String key);
	public Iterable<Vehicle> findByMake(String key);
	public Iterable<Vehicle> findByModel(String key);
	public Iterable<Vehicle> findByMpg(String key);
	public Iterable<Vehicle> findByYear(String key);
	public Iterable<Vehicle> findByPrice(String key);
}
