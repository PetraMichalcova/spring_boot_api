package sk.ukf.myRestApi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.ukf.myRestApi.dao.EmployeeDAO;
import sk.ukf.myRestApi.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {
@Autowired
private EmployeeDAO employeeDAO;
@Override
@Transactional
public List<Employee> findAll() {
return employeeDAO.findAll();
}
@Override
@Transactional
public Employee findById(int theId) {
    return employeeDAO.findById(theId);
}
@Override
@Transactional
public void save(Employee theEmployee) {
employeeDAO.save(theEmployee);
}
@Override
@Transactional
public void update(Employee theEmployee) {
employeeDAO.update(theEmployee);
}
@Override
@Transactional
public void deleteById(int theId) {
employeeDAO.deleteById(theId);
}
}