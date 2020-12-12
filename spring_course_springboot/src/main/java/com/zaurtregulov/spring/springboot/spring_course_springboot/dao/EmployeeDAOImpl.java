package com.zaurtregulov.spring.springboot.spring_course_springboot.dao;

import com.zaurtregulov.spring.springboot.spring_course_springboot.entity.Employee;
// Убираем Hibernate
//import org.hibernate.Session;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAllEmployees() {

//        Session session = entityManager.unwrap(Session.class);
//
////        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class).getResultList();
//
//        Query<Employee> query = session.createQuery("from Employee", Employee.class);
//        List<Employee> allEmployees = query.getResultList();

        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmployees = query.getResultList();

        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {

//        Session session = entityManager.unwrap(Session.class);
//
//        session.saveOrUpdate(employee);

        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());
    }

    @Override
    public Employee getEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//
//        Employee employee = session.get(Employee.class, id);

        // Используем JPA
        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    @Override
    public void delete(int id) {
//        Session session = entityManager.unwrap(Session.class);
//
//        Employee employee = session.get(Employee.class, id);
//        session.delete(employee);

//        Query<Employee> query = session.createQuery("delete from Employee where id = :employeeId");
//        query.setParameter("employeeId", id);
//        query.executeUpdate();

//        Employee employee = entityManager.find(Employee.class, id);
//        entityManager.remove(employee);

        Query query = entityManager.createQuery("delete from Employee where id = :employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();

    }
}