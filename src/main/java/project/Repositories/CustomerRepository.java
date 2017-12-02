package project.Repositories;

import org.springframework.data.repository.CrudRepository;

import project.Database.Customer;;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
