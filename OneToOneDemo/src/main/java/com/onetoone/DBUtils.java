package com.onetoone;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

public class DBUtils {

    private static SessionFactory sessionFactory;

    /*static {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
        }*/

    public static SessionFactory getSessionFactory(){
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
        return sessionFactory;
    }

}
