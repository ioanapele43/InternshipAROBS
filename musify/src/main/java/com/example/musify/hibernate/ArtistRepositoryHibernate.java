package com.example.musify.hibernate;

import com.example.musify.model.Artist;

import javax.persistence.*;
import java.util.List;

public class ArtistRepositoryHibernate {
    public Artist getArtistById(int id){
       /* Query namedQuery= entityManager.createNamedQuery("Artist.findByArtistId");
        namedQuery.setParameter("artistId",id);
        return (Artist) namedQuery.getSingleResult();*/
        return null;
    }
    public static void main(String[] args){
        ArtistRepositoryHibernate aRH=new ArtistRepositoryHibernate();
        aRH.getArtistById(1);
    }
}
