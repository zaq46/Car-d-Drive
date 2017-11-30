package project.Repositories;

import org.springframework.data.repository.CrudRepository;

import project.Database.User;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Long>  {

	public User findByEmail(String email);
	
}