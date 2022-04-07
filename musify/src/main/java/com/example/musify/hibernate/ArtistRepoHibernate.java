package com.example.musify.hibernate;

import com.example.musify.model.Artist;
import com.example.musify.model.Band;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
public class ArtistRepoHibernate {
    public List<Artist> getAllArtists() {
        Transaction transaction = null;
        List<Artist> artists = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Query query= session.createQuery("SELECT a from Artist a ");
            artists = query.getResultList();
            for(Artist artist:artists){
                System.out.println(artist.getFirstName());
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

        return artists;
    }

    public static void main(String[] args){
        ArtistRepoHibernate arh=new ArtistRepoHibernate();
        List<Artist> artists=arh.getAllArtists();
    }
}
