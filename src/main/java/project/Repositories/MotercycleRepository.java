package project.Repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import project.Database.Motorcycle; ;

public interface MotercycleRepository extends CrudRepository<Motorcycle, Long> {

}
