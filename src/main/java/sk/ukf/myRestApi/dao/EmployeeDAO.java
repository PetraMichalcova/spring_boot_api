package sk.ukf.myRestApi.dao;

import java.util.List;

import sk.ukf.myRestApi.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> findAll();
	public void save(Employee student);
	public void update(Employee student);
	public Employee findById(int id);
	public void deleteById(int id);
}
