package com.zaurtregulov.spring.hibernate_one_to_one;

import com.zaurtregulov.spring.hibernate_one_to_one.entity.Detail;
import com.zaurtregulov.spring.hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
//    private static final Logger log = Logger.getLogger(Test1.class);

    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession();
        ) {

            session.beginTransaction();

            Detail detail = session.get(Detail.class, 2);
            detail.getEmployee().setEmpDetail(null);
            session.delete(detail);

            session.getTransaction().commit();
        }
    }
}
