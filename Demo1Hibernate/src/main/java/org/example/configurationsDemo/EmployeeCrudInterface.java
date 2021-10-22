package org.example.configurationsDemo;

import org.hibernate.Session;

import java.util.List;

public interface EmployeeCrudInterface {

    List<Employee> listEmployees(Session session);
    void addEmployee(Employee employee, Session session);
    void updateEmployee(int empId, int salary, Session session);
    void deleteEmployee(int empId, Session session);
}
