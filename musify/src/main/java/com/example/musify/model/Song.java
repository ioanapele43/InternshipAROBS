package com.example.musify.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="title")
    private String title;
    @Column(name="duration")
    private Time duration;
    @Column(name="creation_date")
    private Date creationDate;


    @OneToMany
    private List<AlternativeTitles> alternativeTitles;

    @OneToMany(mappedBy = "songId")
    private  List<SongArtist> songArtists;

    @OneToMany(mappedBy ="songId")
    private List<AlbumSong> albumWhereIsAdded;

    @OneToMany(mappedBy ="songId")
    private List<PlaylistSong> playlistsWhereIsAdded;

    public Song() {
    }

    public Song(String title, Time duration, Date creationDate) {
        this.title = title;

        this.duration = duration;
        this.creationDate = creationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
