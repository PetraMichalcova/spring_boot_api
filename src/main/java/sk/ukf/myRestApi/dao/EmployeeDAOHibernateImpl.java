package sk.ukf.myRestApi.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import sk.ukf.myRestApi.entity.Employee;


@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
@Autowired
private EntityManager entityManager;
@Override
public List<Employee> findAll() {
Session session = entityManager.unwrap(Session.class);
Query<Employee> query = session.createQuery("from Employee", Employee.class);
List<Employee> employees = query.getResultList();
return employees;
}
@Override
public Employee findById(int id) {
Session session = entityManager.unwrap(Session.class);
Employee employee = session.get(Employee.class, id);
return employee;
}
@Override
public void save(Employee employee) {
Session session = entityManager.unwrap(Session.class);
session.saveOrUpdate(employee);
}
@Override
public void deleteById(int id) {
Session session = entityManager.unwrap(Session.class);
Query query = session.createQuery("delete from Employee where id=:employeeId");
query.setParameter("employeeId", id);
query.executeUpdate();
}
@Override
public void update(Employee student) {
	// TODO Auto-generated method stub
	
}

}
