package spring_mvc_hibernate_aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_mvc_hibernate_aop.dao.EmployeeDAO;
import spring_mvc_hibernate_aop.dao.EmployeeDAOIpl;
import spring_mvc_hibernate_aop.entity.Employee;

import javax.transaction.Transactional;
import java.util.List;

//Аннотация отмечает класс, содержащий бизнес-логику
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    //При использовании аннотации Spring берет на себя ответственность за открытие и закрытие транзакции
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}
