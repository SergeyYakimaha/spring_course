package com.zaurtregulov.spring.hibernate_one_to_one;

import com.zaurtregulov.spring.hibernate_one_to_one.entity.Detail;
import com.zaurtregulov.spring.hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
//    private static final Logger log = Logger.getLogger(Test1.class);

    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession();
        ) {

//            Employee employee = new Employee("Zaur", "Tregulov", "IT", 500);
//            Detail detail = new Detail("Baku", "123456789", "zaurtregulov@com");
//
            Employee employee = new Employee("Oleg", "Smirnov", "Sales", 700);
            Detail detail = new Detail("Moscow", "987654321", "olegka@com");

            employee.setEmpDetail(detail);

            session.beginTransaction();

//            Employee employee = session.get(Employee.class, 3);
//            session.delete(employee);

            session.save(employee);

            session.getTransaction().commit();
        }
    }
}
