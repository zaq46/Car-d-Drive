package project.Repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import project.Database.HasUser; ;

public interface HasUserRepository extends CrudRepository<HasUser, Long>{

	
}