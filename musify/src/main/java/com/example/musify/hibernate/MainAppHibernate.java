package com.example.musify.hibernate;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

/**
 * @author imssbora
 */
public class MainAppHibernate {
    public static void getAllArtist(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Check database version
        String hql="from users";
        Query query=session.createQuery(hql);
        List result=query.getResultList();

        System.out.println(result);

        session.getTransaction().commit();
        session.close();


        HibernateUtil.shutdown();
    }
    public static void main(String[] args) {
       getAllArtist();
    }
}