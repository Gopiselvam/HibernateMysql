package com.employeeAccount;

import org.apache.log4j.Logger;
import org.hibernate.Session;

public class EmpAccDao {
    Logger logger = Logger.getLogger(EmpAccDao.class);
    public EmployeeAcc addEmployee(EmployeeAcc employeeAcc){

        logger.debug("Start #addEmployee");
        Session session = DBUtils.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(employeeAcc);
        session.getTransaction().commit();
        logger.debug("End #addEmployee");
        return employeeAcc;

    }

    public EmployeeAcc getEmployee(){
        Session session = DBUtils.getSessionFactory().openSession();
        session.beginTransaction();

        session.getTransaction().commit();
        return null;
    }


    /*
    reference:

    Publication publication = entityManager.createQuery(
    "select p " +
    "from Publication p " +
    "join fetch p.book b " +
    "where " +
    "   b.isbn = :isbn and " +
    "   p.currency = :currency", Publication.class)
.setParameter( "isbn", "978-9730228236" )
.setParameter( "currency", "&" )
.getSingleResult();
     */
    public EmployeeAcc getEmployeeAccByEmail(String email) {
        Session session = DBUtils.getSessionFactory().openSession();
        session.beginTransaction();
        session.getTransaction().commit();
        return employeeAcc;
    }
}
