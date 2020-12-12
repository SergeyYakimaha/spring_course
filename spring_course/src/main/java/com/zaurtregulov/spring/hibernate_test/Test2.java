package com.zaurtregulov.spring.hibernate_test;

import com.zaurtregulov.spring.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
//    private static final Logger log = Logger.getLogger(Test1.class);

    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();

//            Employee emp = new Employee("Elena", "Petrova", "Sales", 800);
//            session.beginTransaction();
//            session.save(emp);
//            session.getTransaction().commit();

//            int myId = emp.getId();
//            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, 900);
            session.getTransaction().commit();

            System.out.println(employee);
        }
    }
}
