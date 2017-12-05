package project.Repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.Database.Truck; ;

public interface TruckRepository extends CrudRepository<Truck, Long>{

}
