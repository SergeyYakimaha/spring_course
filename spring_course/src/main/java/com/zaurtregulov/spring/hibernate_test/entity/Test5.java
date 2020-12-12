package com.zaurtregulov.spring.hibernate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5 {
//    private static final Logger log = Logger.getLogger(Test1.class);

    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {

            Session session = factory.getCurrentSession();
            session.beginTransaction();

/*
            Employee employee = session.get(Employee.class, 38);
            session.delete(employee);
*/

            session.createQuery("delete Employee where name = 'Zaur'").executeUpdate();

            session.getTransaction().commit();

        }
    }
}
