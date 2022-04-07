package com.example.musify.hibernate;

import com.example.musify.model.Artist;
import com.example.musify.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UsersRepoHibernate {
    public List<User> getAllUsers() {
        Transaction transaction = null;
        List<User> users = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Query query= session.createQuery("SELECT u from User u ");
            users = query.getResultList();
            for(User u:users){
                System.out.println(u.getFirstName());
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }

        return users;
    }
    public User getUserById(int id) {
        Transaction transaction = null;
        User user = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Query query= session.createQuery("SELECT u from User u where u.id=:id ");
            query.setParameter("id",id);
            user = (User) query.getSingleResult();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }

        return user;
    }
    public void  addUser(User user) {
        Transaction transaction = null;


        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(user);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }
    public void updateUser(User user) {
        Transaction transaction = null;


        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.saveOrUpdate(user);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }
    public void deleteUser(User user) {
        Transaction transaction = null;


        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();


            session.delete(user);


            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }
    public static void main(String[] args){
        UsersRepoHibernate urh=new UsersRepoHibernate();
        /*List<User> users=urh.getAllUsers();
        for(User u:users){
            System.out.println(u.getFirstName());
        }*/
        //User user=urh.getUserById(1);
        //System.out.println(user.getFirstName());
        User user=new User(10,"try","skadhak","vhvhd","bjbk","knknk","klnjk");
        urh.addUser(user);
        //urh.updateUser(user);
        //urh.deleteUser(user);
    }
}
