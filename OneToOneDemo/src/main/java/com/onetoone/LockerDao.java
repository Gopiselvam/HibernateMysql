package com.onetoone;

import org.hibernate.Session;
import org.hibernate.query.Query;


import java.util.Iterator;
import java.util.List;

public class LockerDao {

    public void addCustomerWithLocker(Customer customer) {
        Session session = DBUtils.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
    }

    public void addLockerToCustomer(int custId, Locker locker){


        Session session = DBUtils.getSessionFactory().openSession();
        session.beginTransaction();
        Customer customer = session.get(Customer.class, custId);
        if(null != customer){
            customer.setLocker(locker);
            session.saveOrUpdate(customer);   // session.save(customer), session.update(customer) also works the same way
        }
        session.getTransaction().commit();

    }


    public Customer getCustomer(int custId){
        Session  session = DBUtils.getSessionFactory().openSession();
        session.beginTransaction();
        Customer customer = session.get(Customer.class, custId);
        session.getTransaction().commit();
        return  customer;
    }

    public Customer deleteLocker(int custId){
        Session session = DBUtils.getSessionFactory().openSession();
        session.beginTransaction();
        Customer customer = session.get(Customer.class, custId);
        if(customer!=null){
            customer.setLocker(null);
        }
        session.update(customer);
        session.getTransaction().commit();
        return customer;
    }

    public void deleteLockerByLockerId(String lockerId){
        Session session = DBUtils.getSessionFactory().openSession();
        session.beginTransaction();
        Locker locker = session.get(Locker.class, lockerId);
        if(null != locker){
            session.delete(locker);
        }
        session.getTransaction().commit();
    }

    public List<String> getAvailableLockers(){
        Session session = DBUtils.getSessionFactory().openSession();
        String customerLockerIds = "SELECT c.LOCKERID FROM Customer c";
        String lockerLockerIds = "SELECT c.LOCKERID FROM Locker c";

        List<String> cusLoc = session.createNativeQuery(customerLockerIds).list();
        List<String> locLoc = session.createNativeQuery(lockerLockerIds).list();
        locLoc.removeAll(cusLoc);
        return locLoc;
    }

    public void addExistingLockerToCustomer(int custId, String lockerId){
        Session session = DBUtils.getSessionFactory().openSession();
        session.beginTransaction();
        Locker locker = session.get(Locker.class, lockerId);
        Customer customer = session.get(Customer.class, custId);
        customer.setLocker(locker);
//        session.saveOrUpdate(customer);
        session.save(customer);
        session.getTransaction().commit();
    }
}
