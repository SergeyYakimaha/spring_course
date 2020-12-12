package com.zaurtregulov.spring.hibernate_test;

import com.zaurtregulov.spring.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test4 {
//    private static final Logger log = Logger.getLogger(Test1.class);

    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {

            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            Employee employee = session.get(Employee.class, 38);
//            employee.setSalary(1500);

            session.createQuery("update Employee set salary = 200 " +
                    "where name = 'Zaur'").executeUpdate();

            session.getTransaction().commit();

        }
    }
}
