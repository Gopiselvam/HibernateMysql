package org.example;

import org.example.configurationsDemo.Employee;
import org.example.configurationsDemo.EmployeeCrudOperations;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("line1");

        hibernateOperations();
        System.out.println( "Hello World!" );

    }

    /**
     * main class for executing hibernate queries
     */
    private static void hibernateOperations() {
        Session session = createSession();
        EmployeeCrudOperations operations = new EmployeeCrudOperations();
        List<Employee> list = operations.listEmployees(session);
        list.stream().map(o-> o).forEach(System.out::println);
    }

    private static Session createSession() {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        org.hibernate.service.ServiceRegistry serviceRegistry = new
                ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);

        return factory.openSession();
    }
}
