package com.example.musify.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
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

    @ManyToMany
    @JoinTable(
            name="song-album",
            joinColumns ={ @JoinColumn(name="album_id")},
            inverseJoinColumns ={ @JoinColumn(name="song_id")}
    )
    private Set<Song> songsFromTheAlbum;

    @ManyToMany
    @JoinTable(name = "albums_song-album",
            joinColumns = @JoinColumn(name = "album_id", referencedColumnName = "song-album_id"))
    private List<Song> song_id = new ArrayList<>();

    public List<Song> getSong_id() {
        return song_id;
    }

    public void setSong_id(List<Song> song_id) {
        this.song_id = song_id;
    }

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
