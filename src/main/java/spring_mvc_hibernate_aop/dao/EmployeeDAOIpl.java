package spring_mvc_hibernate_aop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring_mvc_hibernate_aop.entity.Employee;

import javax.transaction.Transactional;
import java.util.List;

//Данная аннотация используется для DAO
@Repository()
public class EmployeeDAOIpl implements EmployeeDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class).getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        //Метод удобен для данного случая, тк может либо прийти запрос на добавление рабочего с нулевым айди, либо обновление уже существующего рабочего
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee emp = session.get(Employee.class, id);
        return emp;
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee emp = session.get(Employee.class,id);
        session.delete(emp);
    }
}
