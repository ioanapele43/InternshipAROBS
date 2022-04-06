package com.example.musify.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="playlists")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="type")
    private String type;
    @Column(name="created_date")
    private Date createdDate;
    @Column(name="last_update_date")
    private Date lastUpdatedate;

    @ManyToMany
    @JoinTable(
            name="followed_playlists_by_user",
            joinColumns ={ @JoinColumn(name="playlist_id")},
            inverseJoinColumns ={ @JoinColumn(name="user_id")}
    )
    private Set<User> usersWhoFollows;

    @OneToMany(mappedBy ="playlistId")
    private List<PlaylistSong> songs;

    public Playlist() {
    }

    public Playlist( String type, Date createdDate, Date lastUpdatedate) {
        this.type = type;
        this.createdDate = createdDate;
        this.lastUpdatedate = lastUpdatedate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdatedate() {
        return lastUpdatedate;
    }

    public void setLastUpdatedate(Date lastUpdatedate) {
        this.lastUpdatedate = lastUpdatedate;
    }


}
