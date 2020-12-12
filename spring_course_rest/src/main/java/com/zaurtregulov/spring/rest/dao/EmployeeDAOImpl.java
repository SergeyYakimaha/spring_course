package com.zaurtregulov.spring.rest.dao;

import com.zaurtregulov.spring.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public EmployeeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getAllEmployees() {

        Session session = sessionFactory.getCurrentSession();
        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class).getResultList();

//        Query<Employee> query = session.createQuery("from Employee", Employee.class);
//        List<Employee> allEmployees = query.getResultList();

        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();

        Employee employee = session.get(Employee.class, id);

        return employee;
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();

        Employee employee = session.get(Employee.class, id);
        session.delete(employee);

//        Query<Employee> query = session.createQuery("delete from Employee where id = :employeeId");
//        query.setParameter("employeeId", id);
//        query.executeUpdate();

    }
}