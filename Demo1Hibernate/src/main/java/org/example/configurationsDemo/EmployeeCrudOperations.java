package org.example.configurationsDemo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeCrudOperations implements EmployeeCrudInterface{
    @Override
    public List<Employee> listEmployees(Session session) {
        Transaction tx = session.beginTransaction();
//        List<Employee> emps = session.createSQLQuery("select * from Employee").list();
        List<Employee> emps = session.createQuery("FROM Employee").list();
        tx.commit();
        return emps;
    }

    @Override
    public void addEmployee(Employee employee, Session session) {

        Transaction tx = session.beginTransaction();
        session.save(employee);
        tx.commit();

    }

    @Override
    public void updateEmployee(int empId, int salary, Session session) {
        Transaction tx = session.beginTransaction();

        tx.commit();

    }

    @Override
    public void deleteEmployee(int empId, Session session) {
        Transaction tx = session.beginTransaction();

        tx.commit();

    }
}
