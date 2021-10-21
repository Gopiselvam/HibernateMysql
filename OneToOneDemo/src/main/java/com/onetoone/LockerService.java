package com.onetoone;

import org.hibernate.Session;

public class LockerService {

    public void addCustomerWithLocker(Customer customer) {
        Session session = DBUtils.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
    }
}
