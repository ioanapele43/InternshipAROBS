package com.example.musify.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="title")
    private String title;
    @Column(name="duration")
    private Time duration;
    @Column(name="creation_date")
    private Date creationDate;


    @OneToMany
    private List<AlternativeTitles> alternativeTitles;

    /*@OneToMany(mappedBy = "songId")
    private  List<SongArtist> songArtists;*/

    /* @OneToMany(mappedBy ="songId")
    private List<AlbumSong> albumWhereIsAdded;

    @OneToMany(mappedBy ="songId")
    private List<PlaylistSong> playlistsWhereIsAdded;*/

    public Song(String title, Time duration, Date creationDate) {
        this.title = title;

        this.duration = duration;
        this.creationDate = creationDate;
    }
}
