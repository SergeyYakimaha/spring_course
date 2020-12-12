package com.zaurtregulov.spring.hibernate_test;

import com.zaurtregulov.spring.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Test3 {
//    private static final Logger log = Logger.getLogger(Test1.class);

    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {

            Session session = factory.getCurrentSession();
            session.beginTransaction();

            List<Employee> emps;

            emps = session.createQuery("from Employee ").getResultList();
            emps = session.createQuery("from Employee where department = 'Sales'").getResultList();
            emps = session.createQuery("from Employee where department = 'Sales' and " +
                    "surname = 'Petrova'").getResultList();

//            CriteriaBuilder cb = session.getCriteriaBuilder();
//            CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
//            Root<Employee> root = cr.from(Employee.class);
//            cr.select(root).where(cb.gt(root.get("salary"), 900));
//
//            Query<Employee> query = session.createQuery(cr);
//            List<Employee> emps = query.getResultList();

            session.getTransaction().commit();

            emps.forEach(System.out::println);

        }
    }
}
