package project;


import org.springframework.data.repository.CrudRepository;
import project.CarDetails;


//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

public interface CarDetailsRepository extends CrudRepository<CarDetails, Long> {

}