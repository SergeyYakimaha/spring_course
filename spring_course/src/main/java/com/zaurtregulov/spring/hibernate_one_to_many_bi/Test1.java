package com.zaurtregulov.spring.hibernate_one_to_many_bi;

import com.zaurtregulov.spring.hibernate_one_to_many_bi.entity.Department;
import com.zaurtregulov.spring.hibernate_one_to_many_bi.entity.Employee;
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
//            Department dep = new Department("Sales", 800, 1500);
//            Employee emp1 = new Employee("Zaur", "Tregulov", 800);
//            Employee emp2 = new Employee("Elena", "Smirnova", 1500);
//            Employee emp3 = new Employee("Anton", "Sidorov", 1200);
//
//            dep.addEmployeeToDepatment(emp1);
//            dep.addEmployeeToDepatment(emp2);
//            dep.addEmployeeToDepatment(emp3);
//
//            session.beginTransaction();
//            session.save(dep);
//
//            session.getTransaction().commit();
//***********************************************************************
            session.beginTransaction();

            System.out.println("Get department");
            Department dep = session.get(Department.class, 4);

            System.out.println("Show department");
            System.out.println(dep);
            System.out.println("Show employees of the department");
            // При fetch = FetchType.LAZY, для загрузки ВСЕХ работников делаем такой финт !
            System.out.println(dep.getEmps().get(0));

            session.getTransaction().commit();

            System.out.println("Show getEmps -----------------");
            System.out.println(dep.getEmps());
//**********************************************************************
//            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 7);
//
//            System.out.println(employee);
//            System.out.println(employee.getDepartment());
//
//            session.getTransaction().commit();
//********************************************************************
//            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 8);
//
//            session.delete(employee);
//
//            session.getTransaction().commit();

        }
    }
}
