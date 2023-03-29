package com.nbstech.spring.basic.dataaccess.Hibernate;

import com.nbstech.spring.basic.dataaccess.Hibernate.Dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
    public static void main(String[] args) {
//        savingObjectEx();
        retrievingObjectEx();
    }

    public static void savingObjectEx() {
        UserDetails userDetails = new UserDetails();
        userDetails.setId(1);
        userDetails.setName("First name");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(userDetails);
        session.getTransaction().commit();
        session.close();
    }

    public static void retrievingObjectEx() {
        UserDetails userDetails = new UserDetails();
        userDetails.setId(1);
        userDetails.setName("First name");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(userDetails);
        session.getTransaction().commit();
        session.close();

        userDetails = null;

        session = sessionFactory.openSession();
        session.beginTransaction();
        userDetails = (UserDetails) session.get(UserDetails.class, 1);
        System.out.println("User name retrieved is " + userDetails.getName());
    }
}


