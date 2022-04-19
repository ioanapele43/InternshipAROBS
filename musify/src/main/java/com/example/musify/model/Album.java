package com.example.musify.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
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

   @ManyToOne
    private Artist artist ;

    @ManyToOne
    private Band band;

   /* @ManyToMany
    @JoinTable(
            name="album_songs",
            joinColumns = @JoinColumn(name="album_id"),
            inverseJoinColumns = @JoinColumn(name="song_id")
    )
    private List<Song> songs=new ArrayList<Song>();
*/
    @OneToMany(mappedBy = "album")
    private List<AlbumSongs> albumSongs;

    public Album(String title, String description, String genre, Date releaseDate, String label, List<Song> songs) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.label = label;

    }


}
