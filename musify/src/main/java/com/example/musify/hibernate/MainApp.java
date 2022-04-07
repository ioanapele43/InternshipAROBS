package com.example.musify.hibernate;

import com.example.musify.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @author imssbora
 */
public class MainApp {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query= session.createQuery("SELECT u from User u ");
        List<User> users=query.getResultList();
        for(User u:users){
            System.out.println(u.getFirstName());
        }


        session.getTransaction().commit();
        session.close();


        HibernateUtil.shutdown();
    }
}