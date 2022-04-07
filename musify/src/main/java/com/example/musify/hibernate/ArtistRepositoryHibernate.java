package com.example.musify.hibernate;

import com.example.musify.model.Artist;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
public class ArtistRepositoryHibernate {
    public List<Artist> getAllArtists() {
        Transaction transaction = null;
        List<Artist> artists = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Query<Artist> query = session.createNamedQuery("findAllArtists", Artist.class);
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
        ArtistRepositoryHibernate aRH=new ArtistRepositoryHibernate();
        aRH.getAllArtists();
    }
}
