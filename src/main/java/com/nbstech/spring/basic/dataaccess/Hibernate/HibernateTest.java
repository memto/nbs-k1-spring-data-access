package com.nbstech.spring.basic.dataaccess.Hibernate;

import com.nbstech.spring.basic.dataaccess.Hibernate.Dto.Address;
import com.nbstech.spring.basic.dataaccess.Hibernate.Dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
    public static void main(String[] args) {
//        savingObjectEx();
//        retrievingObjectEx();
        tut12ProxyObjectandFetchType();
    }

    public static void tut12ProxyObjectandFetchType() {
        UserDetails userDetails = new UserDetails();
        userDetails.setUserId(1);
        userDetails.setName("First name");

        Address addr1 = new Address();
        addr1.setCity("Ha Noi");
        addr1.setDist("Gia Lam");
        addr1.setPostcode("10000");

        Address addr2 = new Address();
        addr2.setCity("Bac Giang");
        addr2.setDist("Hiep Hoa");
        addr2.setPostcode("20000");

        userDetails.getListOfAddresses().add(addr1);
        userDetails.getListOfAddresses().add(addr2);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(userDetails);
        session.getTransaction().commit();
        session.close();

        userDetails = null;
        session = sessionFactory.openSession();

        //=== LAZY:
//        //= only get UserDetails not address
//        userDetails = (UserDetails) session.get(UserDetails.class, 1);
//
//        //= get address
//        session.close(); // below will error
//        System.out.println(userDetails.getListOfAddresses().size());
        // << LAZY

        //=== EAGER:
        //= get UserDetails and address
        userDetails = (UserDetails) session.get(UserDetails.class, 1);

        //= get address
        session.close(); // below will work
        System.out.println(userDetails.getListOfAddresses().size());
        // << EAGER
    }

    public static void savingObjectEx() {
        UserDetails userDetails = new UserDetails();
        userDetails.setUserId(1);
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
        userDetails.setUserId(1);
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


