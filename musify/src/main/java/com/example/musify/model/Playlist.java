package com.example.musify.model;

import java.sql.Date;
import java.util.List;

public class Playlist {
    private int id;
    private User owner;
    private String type;
    private Date createdDate;
    private Date lastUpdatedate;
    private List<Song> songs;

    public Playlist(User owner, String type, Date createdDate, Date lastUpdatedate, List<Song> songs) {
        this.owner = owner;
        this.type = type;
        this.createdDate = createdDate;
        this.lastUpdatedate = lastUpdatedate;
        this.songs = songs;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
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

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
