import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
public class UserRepository {
    public List<User> getAllUsers() {
        Transaction transaction = null;
        List<User> artists = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Query<User> query = session.createNamedQuery("findAllUsers", User.class);
            artists = query.getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }

        return artists;
    }

    public static void main(String[] args){
        UserRepository ur=new UserRepository();
        ur.getAllUsers();

    }
}
