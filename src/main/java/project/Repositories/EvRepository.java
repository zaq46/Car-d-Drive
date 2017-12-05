package project.Repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import project.Database.Ev ;

public interface EvRepository extends CrudRepository<Ev, Long> {

}
