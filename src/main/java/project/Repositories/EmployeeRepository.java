package project.Repositories;

import org.springframework.data.repository.CrudRepository;


import project.Database.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Long>  {

	public Employee findByUserId(Long id);
}
