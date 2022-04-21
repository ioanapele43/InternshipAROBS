package com.example.musify.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "playlists")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "type")
    private String type;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "last_update_date")
    private Date lastUpdatedate;

    @ManyToOne
    private User owner;

    @ManyToMany
    @JoinTable(
            name = "followed_playlists_by_user",
            joinColumns = {@JoinColumn(name = "playlist_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private Set<User> usersWhoFollows;
/*
    @OneToMany
    private List<Song> songs=new ArrayList<Song>();

    @OneToMany(mappedBy ="playlistId")
    private List<PlaylistSong> songs;*/

    public Playlist(String type, Date createdDate, Date lastUpdatedate) {
        this.type = type;
        this.createdDate = createdDate;
        this.lastUpdatedate = lastUpdatedate;
    }


}
