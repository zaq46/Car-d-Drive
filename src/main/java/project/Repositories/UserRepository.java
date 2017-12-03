package project.Repositories;

import org.springframework.data.repository.CrudRepository;

import project.Database.User;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Long>  {

	public Iterable<User> findByEmail(String email);
	public Iterable<User>  findByFirstName(String firstname);
	public Iterable<User>  findByLastName(String lastname);
	public Iterable<User>  findByFirstNameAndLastName(String firstname, String lastname);
	public Iterable<User>  findByFirstNameAndLastNameAndEmail(String firstname, String lastname, String email);

	
}