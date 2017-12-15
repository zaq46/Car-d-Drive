package project.Repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.Database.HasVehicle; 

public interface HasVehicleRepository extends CrudRepository<HasVehicle, Long> {

}
