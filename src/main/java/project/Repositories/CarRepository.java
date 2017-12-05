package project.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import project.Database.Car ;

public interface CarRepository extends CrudRepository<Car, Long>{

}
