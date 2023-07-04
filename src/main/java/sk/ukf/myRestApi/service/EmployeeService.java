package sk.ukf.myRestApi.service;

import java.util.List;

import sk.ukf.myRestApi.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();

	void save(Employee student);
	
	void update(Employee student);

     Employee findById(int id);

	void deleteById(int id);
	
}

