package com.example.musify;
import com.example.musify.hibernate.ArtistRepositoryHibernate;
import com.example.musify.model.Artist;
import com.example.musify.model.Band;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

/**
 * @author imssbora
 */
public class MainAppHibernate {

    public static void main(String[] args) {
        ArtistRepositoryHibernate artistRepositoryHibernate=new ArtistRepositoryHibernate();
        List<Artist> artists=artistRepositoryHibernate.getAllArtists();
       /* for(Artist artist:artists){
            System.out.println(artist.getIdPerson()+" , "+artist.getFirstname()+" , "+artist.getLastname());
        }*/
    }
}