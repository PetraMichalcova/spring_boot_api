package sk.ukf.myRestApi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sk.ukf.myRestApi.entity.Employee;
import sk.ukf.myRestApi.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
@Autowired
private EmployeeService employeeService;
@GetMapping("/employees")
public List<Employee> findAll() {
return employeeService.findAll();
}
@GetMapping("/employees/{id}")
public Employee getEmployee(@PathVariable int id) {
Employee employee = employeeService.findById(id);
if (employee == null) {
throw new RuntimeException("Employee id not found - " + id);
}
return employee;
}
@PostMapping("/employees")
public Employee addEmployee(@RequestBody Employee employee) {
employee.setId(0);
employeeService.save(employee);
return employee;
}
@PutMapping("/employees/{id}")
public Employee updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
    // Make sure the ID of the employee object matches the ID in the path variable
	Employee employeeNext = employeeService.findById(id);
	if(employee.getFirstName()!=null) employeeNext.setFirstName(employee.getFirstName());
	else if(employee.getLastName()!=null) employeeNext.setFirstName(employee.getLastName());
	else if(employee.getEmail()!=null) employeeNext.setEmail(employee.getEmail());
	
    employeeService.save(employeeNext);
    return employeeNext;
}
@DeleteMapping("/employees/{id}")
public String deleteEmployee(@PathVariable int id) {
Employee employee = employeeService.findById(id);
if (employee == null) {
throw new RuntimeException("Employee id not found - " + id);
}
employeeService.deleteById(id);
return "Deleted employee id - " + id;
}
}
