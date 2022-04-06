package com.example.musify.hibernate;
import com.example.musify.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
public class MainAppHibernate {
    public static void main(String[] args) {
       /* Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Check database version
        String sql = "select version()";

        String result = (String) session.createNativeQuery(sql).getSingleResult();
        System.out.println(result);

        User user=new User(9,"asda","asdas","asdasd","lmlk","kljkj","normal");
        session.persist(user);

        session.getTransaction().commit();
        session.close();


        HibernateUtil.shutdown();*/
        //Query jpqlQuery=getEntityManager().createQuery("Select u from users u where u.id=1;");
    }
}
