package com.zaurtregulov.spring.one_to_many_uni;

import com.zaurtregulov.spring.one_to_many_uni.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {

    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession();
        ) {
//            Department dep = new Department("Sales", 500, 1500);
//            Employee emp1 = new Employee("Oleg", "Ivanov", 800);
//            Employee emp2 = new Employee("Andrey", "Sidorov", 1000);
//
//            dep.addEmployeeToDepatment(emp1);
//            dep.addEmployeeToDepatment(emp2);
//
//            session.beginTransaction();
//            session.save(dep);
//
//            session.getTransaction().commit();

//            session.beginTransaction();
//            Department dep = session.get(Department.class, 3);
//
//            System.out.println(dep);
//            System.out.println(dep.getEmps());
//
//            session.getTransaction().commit();
//
//            System.out.println(dep);
//            System.out.println(dep.getEmps());

//            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 10);
//
//            System.out.println(employee);
//
//            session.getTransaction().commit();

            session.beginTransaction();
            Department department = session.get(Department.class, 3);

            session.delete(department);

            session.getTransaction().commit();
        }
    }
}
