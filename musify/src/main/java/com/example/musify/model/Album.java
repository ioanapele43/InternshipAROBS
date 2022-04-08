package com.example.musify.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@Entity
@Table(name="albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="title")
    private String title;
    @Column(name="description")
    private String description;
    @Column(name="genre")
    private String genre;
    @Column(name="release_date")
    private Date releaseDate;
    @Column(name="label")
    private String label;

    @OneToMany
    private List<Artist> artists = new ArrayList<Artist>();

    @OneToMany
    private List<Song> songs=new ArrayList<Song>();

    @OneToMany
    private List<Band> bands = new ArrayList<Band>();

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    /*
        @OneToMany(mappedBy ="albumId")
        private List<AlbumSong> songs;

        @OneToMany(mappedBy = "albumId")
        private List<AlbumArtist> albumArtist;
    */
    public Album() {
    }

    public Album(String title, String description, String genre, Date releaseDate, String label, List<Song> songs) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.label = label;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
